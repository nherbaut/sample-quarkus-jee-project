package fr.pantheonsorbonne.ufr27.miage.camel;

public interface TokenGateway {

    void submitToken(String email, String bankName, String token);
}
