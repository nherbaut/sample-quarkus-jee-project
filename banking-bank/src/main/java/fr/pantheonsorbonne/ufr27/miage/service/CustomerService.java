package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Customer;

public interface CustomerService {
    Customer findCustomer(String email);
}
