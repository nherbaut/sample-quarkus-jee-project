package top.nextnet.service;

import fr.pantheonsorbonne.ufr27.miage.dto.TokenSend;
import fr.pantheonsorbonne.ufr27.miage.dto.User;
import jakarta.inject.Inject;
import top.nextnet.dao.TokenDAO;
import top.nextnet.model.Token;

public interface TokenService {

   Token saveToken(TokenSend tokenSend);

   Token getTokenForUser(Token token);
}
