package fr.pantheonsorbonne.ufr27.miage.dto.Tasvee;

public record BusinessPlan(
        ExpertiseJuridique expertiseJuridique,
        ExpertiseFinanciere expertiseFinancière,
        Siret siretEntreprise,
        Organigramme organigramme,
        SiteWeb siteWeb) {
}
