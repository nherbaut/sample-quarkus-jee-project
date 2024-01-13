package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import fr.pantheonsorbonne.ufr27.miage.service.CashbackService;

@ApplicationScoped
public class CashbackGateway {

    @Inject
    CashbackService cashbackService;

    public Cashback cashback(Cashback c){
        return cashbackService.cashback(c);
    }

}
