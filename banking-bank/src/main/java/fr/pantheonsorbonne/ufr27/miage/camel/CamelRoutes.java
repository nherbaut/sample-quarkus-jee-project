package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.DemandeAuthorisation;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.NotificationFoundException;
import fr.pantheonsorbonne.ufr27.miage.service.CompteService;
import fr.pantheonsorbonne.ufr27.miage.service.Constante;
import fr.pantheonsorbonne.ufr27.miage.service.NotificationService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {

    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankName")
    String bankName;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.clientEmail")
    String clientEmail;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankGroup")
    String bankGroup;
    @Inject
    CompteService compteService;
    @Inject
    NotificationService notificationService;
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

        onException(NotificationFoundException.NotificationAuthorisationFoundException.class)
                .handled(true)
                .setHeader("success",simple("false"))
                .setBody(simple("Request has already been sent for today ! It will expire in the next 24 hours"));

        from("sjms2:"+jmsPrefix+"requestSynch?exchangePattern=InOut")
                .autoStartup(isRouteEnabled)
                .filter(header("bankName").isEqualTo(bankName))
                .filter(header("clientEmail").isEqualTo(clientEmail))
                .choice()
                .when(header("bankGroup").isEqualTo(Constante.BPCE_GROUP_BANK))
                .unmarshal().json(DemandeAuthorisation.class)
                .endChoice()
                .otherwise()
                .unmarshal().jacksonXml(DemandeAuthorisation.class)
                .end()
                .bean(compteService,"login")
                .log("Connection success ! verify if you have already sent a synchronization request for today ...")
                .bean(notificationService,"verifyNotificationCreated")
                .log("Sending notification for user ...")
                .bean(notificationService,"newNotification")
                .setHeader("success",simple("true"))
                .choice()
                .when(header("bankGroup").isEqualTo(Constante.BPCE_GROUP_BANK))
                .marshal().json()
                .endChoice()
                .otherwise()
                .marshal().jacksonXml();


    from("direct:responseSynchro")
                .autoStartup(isRouteEnabled)
                .setHeader("bankGroup",simple(bankGroup))
                .setHeader("bankName",simple(bankName))
                .choice()
                .when(header("bankGroup").isEqualTo(Constante.BPCE_GROUP_BANK))
                .marshal().json()
                .to("sjms2:topic:" + jmsPrefix + "respondSynchro")
                .otherwise()
                .marshal().jacksonXml()
                .to("sjms2:topic:" + jmsPrefix + "respondSynchro");

    }
}
