package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.SecretPassword;

public interface SecretPasswordDAO {

    SecretPassword findSecretPassword(Integer password) throws PasswordIncorrectException;
}