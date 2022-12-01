package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.VillagerDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.VillagerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Villager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class VillagerServiceImpl implements VillagerService {

    @Inject
    VillagerDAO villagerDAO;

    @Override
    public Collection<Villager> listVillager() {
        return villagerDAO.listAllVillager();
    }
}


