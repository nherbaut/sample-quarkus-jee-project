package fr.pantheonsorbonne.ufr27.miage.dto;

public record BusinessPlan(
        ExpertiseJuridique expertiseJuridique,
        ExpertiseFinanciere expertiseFinancière,
        String siretEntreprise,
        Organigramme organigramme,
        String siteWeb) {
}
