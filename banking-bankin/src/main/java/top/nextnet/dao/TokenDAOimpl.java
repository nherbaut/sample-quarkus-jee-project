package top.nextnet.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import top.nextnet.model.Token;

@ApplicationScoped
public class TokenDAOimpl implements TokenDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    public Token createNewToken(int idbank, int idaccount, String token) {
        return null;
    }
}
