package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;

@ApplicationScoped
public class AccountServiceImpl implements AccountService{


    @Inject
    AccountDAO accountDAO;

    private ClientDTO convertAccountToClientDTO(Account account){
        return new ClientDTO(account.getId());
    }

    @Override
    public Integer getTotalPoints(Integer client_id) throws AccountNotFoundException {
        //trouve d'abord le compte client
        //ensuite retourne le nombre de points que le client possède sur son compte client
        return accountDAO.getTotalPoints(client_id);
    }

    @Override
    public void addPointsToAccount(Integer client_id) throws AccountNotFoundException {
        //rajoute des points après que le client ai effectué un achat
        //il faut récuperer le total price et convertir chaque euro en 10 points
        accountDAO.addPointsToAccount(client_id);
    }

    @Override
    public void useBonusPoints(Integer client_id) throws AccountNotFoundException {
        //si le compte du client a atteint un total de 300 il doit avoir une réduction de 10% sur le prix
        //et on initialise le nombre de points à 0
        //sinon message d'erreur maximum de points non atteint pour être utiliser
        accountDAO.useBonusPoints(client_id);
    }

    @Override
    public ClientDTO verifyClientAccount(Integer clientId) {
        try {
            Account c = accountDAO.findClientAccount(clientId);
            return convertAccountToClientDTO(c);
        } catch (AccountNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
