package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
@ApplicationScoped
public class VendorDAOImpl implements VendorDAO {

    @Inject
    EntityManager em;

    @Override
    public Vendor findById(int vendorId) {
        return em.find(Vendor.class, vendorId);
    }
}
