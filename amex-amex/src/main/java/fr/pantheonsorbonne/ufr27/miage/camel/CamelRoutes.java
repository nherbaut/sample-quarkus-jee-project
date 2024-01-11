package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.camel.ClientGateway;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;

    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;
    @Inject
    CamelContext camelContext;

    @Inject
    ClientGateway clientGateway;

    @Inject
    TransactionGateway transactionGateway;

    @Inject
    CashbackGateway cashbackGateway;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        //from("sjms2:queue:Amex") from aurelie
        from("file:data/testFolder")
                .unmarshal().json(JsonLibrary.Jackson, LinkedHashMap.class)
                .process(exchange -> {
                    LinkedHashMap<String, Object> jsonMap = exchange.getIn().getBody(LinkedHashMap.class);
                    Client client = new Client();
                    client.setIdClient((Integer) jsonMap.get("idClient"));
                    client.setAge((int) jsonMap.get("age"));
                    client.setProfession((String) jsonMap.get("profession"));
                    client.setGenre((String) jsonMap.get("genre"));
                    double price = ((double) jsonMap.get("prix"));
                    clientGateway.client(client, price);
                    exchange.setProperty("idClient", client.getIdClient());
                })
                .bean(transactionGateway, "transaction")
                .setExchangePattern(ExchangePattern.InOut)
                .marshal().json()
                .to("file:data/folder2");//ENVOYER ET RECEVOIR DE LA PART DE SIMON
                /*.unmarshal().json(Cashback.class)
                .bean(cashbackGateway, "cashback")
                .process(exchange -> {
                    Cashback result = exchange.getIn().getBody(Cashback.class);
                    Transaction t = transactionGateway.getMontantTransaction(result.getIdTransaction());
                    Map<String, Object> jsonOutput = new HashMap<>();
                    jsonOutput.put("montant", t.getMontantTransaction());
                    jsonOutput.put("idClient", result.getIdClient());
                    jsonOutput.put("taux", result.getTauxCashback());
                    exchange.getIn().setBody(jsonOutput);
                })
                .marshal().json()
                .to("file:data/folderToSlim"); //ENVOYER SUR LA QUEUE DE SELIM*/

        //PREPARATION PARTIE SIMON ET SELIM
        from("file:data/folderInfoSimon") //from simon
                .unmarshal().json(Cashback.class)
                .bean(cashbackGateway, "cashback")
                .process(exchange -> {
                    Cashback result = exchange.getIn().getBody(Cashback.class);
                    Transaction t = transactionGateway.getMontantTransaction(result.getIdTransaction());
                    Map<String, Object> jsonOutput = new HashMap<>();
                    jsonOutput.put("montant", t.getMontantTransaction());
                    jsonOutput.put("idClient", result.getIdClient());
                    jsonOutput.put("taux", result.getTauxCashback());
                    exchange.getIn().setBody(jsonOutput);
                })
                .marshal().json()
                .to("file:data/folderToSlim");

        //from("direct:sendToMarketing")
                //VOIR APRES
                //.to("file:data/folderMarket");
                //.to("sjms2:AmexMarketing") // to marketing
    }
}
