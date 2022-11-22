package fr.pantheonsorbonne.ufr27.miage.camel;


import fr.pantheonsorbonne.ufr27.miage.service.ProductService;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CamelRoutes extends RouteBuilder {


    @ConfigProperty(name = "fr.pantheonsorbonne.ufr27.miage.jmsPrefix")
    String jmsPrefix;

    @Inject
    CamelContext camelContext;

    //@Inject
    ProductService productService;

    @Override
    public void configure() throws Exception {

        camelContext.setTracing(true);

        from("jms:queue/miage.register")
                .unmarshal().json()
                //.bean(productService, "getProductList");
                //Faire en sorte d'appeler productService.getProductList et envoyer la réponse dans la queue
                .to("jms:queue/miage.productContent");

    }

}
