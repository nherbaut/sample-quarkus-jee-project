package fr.pantheonsorbonne.ufr27.miage.dto.Entreprise;

import fr.pantheonsorbonne.ufr27.miage.dto.BilanComptable;
import fr.pantheonsorbonne.ufr27.miage.dto.Organigramme;
import fr.pantheonsorbonne.ufr27.miage.dto.SiteWeb;
import fr.pantheonsorbonne.ufr27.miage.dto.Statut;

public record OfferForm(
        BilanComptable bilanComptable,
        Statut statut,
        ObjectifLevee objectLevee,
        Siret siretEntreprise,
        Organigramme organigramme,
        CvDirigeant cvDirigeant,
        SiteWeb siteWeb) {
}

