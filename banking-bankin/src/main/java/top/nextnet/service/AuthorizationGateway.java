package top.nextnet.service;

import fr.pantheonsorbonne.ufr27.miage.dto.User;

public interface AuthorizationGateway {
    void sendAuthorizationRequest(int bankId, User user);
}
