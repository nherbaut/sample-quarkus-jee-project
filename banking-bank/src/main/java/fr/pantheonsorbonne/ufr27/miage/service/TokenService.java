package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.TokenGenerationException;

public interface TokenService {
    String generateToken(String username) throws TokenGenerationException;
}
