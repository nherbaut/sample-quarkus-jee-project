package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Genre;
import fr.pantheonsorbonne.ufr27.miage.model.Client;

public interface ClientDAO {

    Client createClient(int idClient, String genre, int age, String profession);
}