package fr.pantheonsorbonne.ufr27.miage.dto.common;

import fr.pantheonsorbonne.ufr27.miage.dto.OnePager;

public class NDAProduction extends NDA<OnePager>{
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
