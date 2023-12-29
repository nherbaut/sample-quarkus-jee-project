package fr.pantheonsorbonne.ufr27.miage.dto;

public record OfferForm(
        BilanComptable bilanComptable,
        Statut statut,
        ObjectifLevee objectLevee,
        Siret siretEntreprise,
        Organigramme organigramme,
        CvDirigeant cvDirigeant,
        SiteWeb siteWeb) {
}

