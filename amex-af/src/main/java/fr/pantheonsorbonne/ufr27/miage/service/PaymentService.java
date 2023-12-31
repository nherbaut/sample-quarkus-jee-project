package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ConfirmationPayment;
import fr.pantheonsorbonne.ufr27.miage.dto.InformationPayment;

public interface PaymentService {

    ConfirmationPayment pay(InformationPayment informationPayment);
}
