package fr.pantheonsorbonne.ufr27.miage.dto;

import fr.pantheonsorbonne.ufr27.miage.dto.common.NDA;

public class NDANegociation extends NDA<Proposition> {
    private boolean signatureFonds;

    public NDANegociation(Proposition proposition, boolean signatureTasvee, boolean signatureFonds) {
        super(proposition, signatureTasvee);
        this.signatureFonds = signatureFonds;
    }

    // Getters et setters
    public boolean isSignatureFonds() {
        return signatureFonds;
    }

    public void setSignatureFonds(boolean signatureFonds) {
        this.signatureFonds = signatureFonds;
    }
}
