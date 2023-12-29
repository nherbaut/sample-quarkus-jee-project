package fr.pantheonsorbonne.ufr27.miage.dto.Fond;

import fr.pantheonsorbonne.ufr27.miage.dto.ExpertiseFinanciere;
import fr.pantheonsorbonne.ufr27.miage.dto.ExpertiseJuridique;
import fr.pantheonsorbonne.ufr27.miage.dto.Siret;

public record OnePager(
        ExpertiseJuridique expertiseJuridique,
        ExpertiseFinanciere expertiseFinancière,
        Siret siretEntreprise) {
}