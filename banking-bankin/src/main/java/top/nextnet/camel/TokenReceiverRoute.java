package top.nextnet.camel;

import fr.pantheonsorbonne.ufr27.miage.dto.TokenSend;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import top.nextnet.service.TokenService;

@ApplicationScoped
public class TokenReceiverRoute extends RouteBuilder {

    @ConfigProperty(name = "camel.routes.enabled", defaultValue = "true")
    boolean isRouteEnabled;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;
    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.bankName")
    String bankName;

    @Inject
    TokenService tokenService;

    @Override
    public void configure() {
        from("direct:token")
                .process(exchange -> {
                    TokenSend tokenSend = exchange.getIn().getBody(TokenSend.class);
                    tokenService.saveToken(tokenSend);
                });
    }
}

