package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.DemandeAuthorisation;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Notification;

import java.util.Collection;

public interface NotificationService {
    Collection<Notification> notificationAuthorisationAvailableForAnAccount(int idAccount);

    Notification newNotification(DemandeAuthorisation demandeAuthorisation) throws BankCustomerNotFoundException, BankAccountNotFoundException;
}
