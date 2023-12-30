package fr.pantheonsorbonne.ufr27.miage.dto;

public record OfferForm(
        BilanComptable bilanComptable,
        Statut statut,
        int objectLevee,
        String siretEntreprise,
        int organigramme,
        CvDirigeant cvDirigeant,
        String siteWeb) {
}

