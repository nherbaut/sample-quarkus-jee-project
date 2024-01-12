package top.nextnet.dao;

/*
@ApplicationScoped

public class BankDAOimpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;
    public Bank findMatchingBank(String name) {
        try {
            Bank c = (Bank) em.createQuery("Select c from Bank c where c.name=:name").setParameter("name", name).getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
    */