package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.CustomerDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.NotificationDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.DemandeAuthorisation;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.NotificationNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import fr.pantheonsorbonne.ufr27.miage.model.Notification;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.*;


@ApplicationScoped
public class NotificationServiceImpl implements NotificationService {

    @Inject
    NotificationDAO notificationDAO;
    @Inject
    CustomerDAO customerDAO;
    @Inject
    AccountDAO accountDAO;
    private static final Date currentDate = new Date();

    @Override
    @Transactional
    public Collection<Notification> notificationAuthorisationAvailableForAnAccount(int idAccount){
        try{
            List<Notification> notifListRaw = new LinkedList<>(notificationDAO.findNotificationAuthorisationAvailableForAccount(idAccount));
            List<Notification> notifListAvailable = new ArrayList<>();

            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(currentDate);

            for(Notification n : notifListRaw){
                cal1.setTime(n.getDate());
                if(!(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                        cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                        cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH))){

                    notificationDAO.updateNotificationEtat(n.getIdNotification(),Constante.EXPIRED);
                }else{
                    notifListAvailable.add(n);
                }
            }
            return notifListAvailable;
        }catch(NotificationNotFoundException | Exception e){
            return null;
        }
    }
    @Override
    @Transactional
    public Notification newNotification(DemandeAuthorisation demandeAuthorisation) throws BankCustomerNotFoundException,BankAccountNotFoundException{
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);

            Customer c = customerDAO.findMatchingCustomer(demandeAuthorisation.getUser().getEmail());
            Account a = accountDAO.findMatchingAccount(c.getIdCustomer());

            java.sql.Date dateFormatSql = new java.sql.Date(cal.get(Calendar.YEAR)-1900,cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_YEAR));

            Notification n = notificationDAO.createNewNotification(demandeAuthorisation.getTexte(), Constante.VALID,a.getIdAccount(),dateFormatSql,Constante.AUTHORIZATION);

            return n;
        } catch (BankCustomerNotFoundException e) {
            throw new BankCustomerNotFoundException();
        }catch (BankAccountNotFoundException e) {
            throw new BankAccountNotFoundException();
        }
    }

}
