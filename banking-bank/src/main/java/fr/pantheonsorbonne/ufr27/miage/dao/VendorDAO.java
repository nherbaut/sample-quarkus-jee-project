package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Vendor;

public interface VendorDAO {
    Vendor findById(int vendorId);
}
