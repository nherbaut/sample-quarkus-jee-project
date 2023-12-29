package fr.pantheonsorbonne.ufr27.miage.dto;

import fr.pantheonsorbonne.ufr27.miage.dto.common.NDA;

public class NDAProduction extends NDA<OnePager> {
    private boolean signatureFonds;

    public NDAProduction(OnePager onePager, boolean signatureTasvee, boolean signatureFonds) {
        super(onePager, signatureTasvee);
        this.signatureFonds = signatureFonds;
    }

    public boolean isSignatureFonds() {
        return signatureFonds;
    }

    public void setSignatureFonds(boolean signatureFonds) {
        this.signatureFonds = signatureFonds;
    }
}
