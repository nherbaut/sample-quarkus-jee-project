package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import fr.pantheonsorbonne.ufr27.miage.service.CashbackService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CashbackGateway {
    @Inject
    CashbackService cashbackService;

    public Cashback cashback(Cashback c){
        return cashbackService.cashback(c);
    }
}
