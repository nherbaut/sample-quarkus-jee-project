package fr.pantheonsorbonne.ufr27.miage.dto;

public record NDA(
        Siret numeroDeSiret,
        String tasveeSonNumeroDeSiret,
        Boolean partenariat,
        int objectifDeLevé,
        int pourcentageComissionTasvee) {
}

public record NDACommercialisation(PropositionFonds propositionFonds, boolean signatureTasvee, boolean signatureFonds, boolean signatureEntreprise) {
}
public record NDANegotiation(PropositionFonds propositionFonds, boolean signatureTasvee, boolean signatureFonds) {
}

