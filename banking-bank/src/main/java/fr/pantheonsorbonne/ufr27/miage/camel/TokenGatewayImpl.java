package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.dto.TokenSend;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;

@ApplicationScoped

public class TokenGatewayImpl implements TokenGateway{
    @Inject
    CamelContext camelContext;

    @Override
    public void submitToken(String email, String idbank, String token) {
        try (ProducerTemplate template = camelContext.createProducerTemplate()) {
            template.sendBody("direct:token", new TokenSend(email, idbank, token));
        } catch (java.io.IOException e) {
            throw new RuntimeException("Erreur lors de l'envoi du token", e);
        }
    }
}
