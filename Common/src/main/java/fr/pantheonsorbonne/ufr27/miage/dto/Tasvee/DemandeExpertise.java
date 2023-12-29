package fr.pantheonsorbonne.ufr27.miage.dto.Tasvee;

public record DemandeExpertise<T>(
        String formuledepolitesse,
        String destinaire,
        T typeExpertise)
{

}
