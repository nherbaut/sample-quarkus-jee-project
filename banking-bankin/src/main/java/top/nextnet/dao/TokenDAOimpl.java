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
    @Transactional
    public Token createNewToken (int idbank, int idaccount, String token) {
        Token t = new Token(idbank, idaccount, token);
        em.persist(t);
        return t;
    }

    @Override
    public Token findTokenByUser(String email) {
        return null;
    }


}
