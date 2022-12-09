package fr.pantheonsorbonne.ufr27.miage.service;

public class AccountServiceImpl implements AccountService{


    @Override
    public Integer getTotalPoints(Integer client_id) {
        //retourne le nombre de points que le client possède sur son compte client
        return null;
    }

    @Override
    public Integer addPointsToAccount(Integer account_id, Integer client_id) {
        //rajoute des point après que le client ai effectué un achat
        //il faut récuperer le total price et convertir chaque euro en 10 points
        return null;
    }

    @Override
    public Integer useBonusPoints(Integer account_id, Integer client_id) {
        //dans le cas ou le client veut utiliser ses points lors de l'achat on doit décrémenter
        //le nombre de points utilisés de son compte
        return null;
    }

}
