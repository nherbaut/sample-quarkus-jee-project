package fr.pantheonsorbonne.ufr27.miage.resources;

import fr.pantheonsorbonne.ufr27.miage.exception.VillagerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Villager;
import fr.pantheonsorbonne.ufr27.miage.service.VillagerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("villager")
public class VillagerResource {

    @Inject
    VillagerService villagerService;

    @Path("/")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Collection<Villager> listVillager() throws VillagerNotFoundException {
        return villagerService.listVillager();
    }

}
