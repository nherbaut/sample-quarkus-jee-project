package top.nextnet.camel.gateways;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import java.io.IOException;

@ApplicationScoped
public class AuthorizationGatewayImpl implements top.nextnet.service.AuthorizationGateway {

    @Inject
    CamelContext context;

    @Override
    public void sendAuthorizationRequest(String bankGroup, User user) {
        try (ProducerTemplate producer = context.createProducerTemplate()) {
            // String userJson = convertUserToJson(user);
            producer.sendBodyAndHeader("direct:cli", user, "bankGroup", bankGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertUserToJson(User user) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}


