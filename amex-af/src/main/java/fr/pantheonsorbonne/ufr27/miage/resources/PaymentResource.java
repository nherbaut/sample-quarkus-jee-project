package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;
import fr.pantheonsorbonne.ufr27.miage.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("payment")
public class PaymentResource {

    @Inject
    PaymentService paymentService;

    @POST
    public ConfirmationPayment pay(InformationPayment informationPayment){
        return paymentService.pay(informationPayment);
    }
}
