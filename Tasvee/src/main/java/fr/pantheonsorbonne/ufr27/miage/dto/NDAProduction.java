package fr.pantheonsorbonne.ufr27.miage.dto;

import fr.pantheonsorbonne.ufr27.miage.dto.Tasvee.OnePager;
import fr.pantheonsorbonne.ufr27.miage.dto.common.NDA;

public class NDAProduction extends NDA<Fond.OnePager> {
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
