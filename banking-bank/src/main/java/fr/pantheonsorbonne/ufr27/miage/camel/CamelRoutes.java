package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.cli.UserInterface;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {
    @Inject
    UserInterface eCommerce;
    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankName")
    String bankName;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.clientEmail")
    String clientEmail;
    @Inject
    CamelContext camelContext;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        onException(BankAccountNotFoundException.class)
                .handled(true)
                .setHeader("success",simple("false"))
                .setBody(simple("Account not found"));

        onException(BankCustomerNotFoundException.class)
                .handled(true)
                .setHeader("success",simple("false"))
                .setBody(simple("Customer Not found"));

        from("sjms2:" + jmsPrefix + "authorization?exchangePattern=InOut")
                .bean(eCommerce, "processAuthorizationRequest")
                .to("direct:cli")
        ;

                /*
                .bean(eCommerce, "showTest").stop()
                .otherwise()
                .log("Message not successfully received. Bank ID: ${header.bankId}, Message Body: ${body}")
                 */



    }
}
