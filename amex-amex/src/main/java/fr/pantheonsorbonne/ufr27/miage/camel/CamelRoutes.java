package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.camel.ClientGateway;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

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

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        //from("sjms2:queue:Amex") from aurelie
        from("file:data/testFolder")
                .unmarshal().json(Client.class)
                .bean(clientGateway, "client")
                .log("PASSAGE");

        //from("sjms2:queue:AmexS" from simon
        from("file:data/testFolder2");
            //FAIRE EN SORTE DE DEMANDER LE TAUX DE CASHBACK AVEC L ID DU CLIENT ET QUAND JE RECUPERE CREER UN DATA DANS CASHBACK

        from("direct:senToCashback")
                //ENVOYER A SLIM L'ID DU CLIENT/LE MONTANT/taux cashback
                .to("file:date/testFolder3");
                //.to("sjms2:AmexCashback") to Selim

        from("direct:sendToMarketing")
                //VOIR APRES
                .to("file:data/folderMarket");
                //.to("sjms2:AmexMarketing") // to marketing
    }
}
