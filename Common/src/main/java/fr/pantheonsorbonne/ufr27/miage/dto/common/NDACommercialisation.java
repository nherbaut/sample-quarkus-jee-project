package fr.pantheonsorbonne.ufr27.miage.dto.common;


public class NDACommercialisation extends NDA<Proposition> {
    private boolean signatureFonds;
    private boolean signatureEntreprise;

    public NDACommercialisation(Proposition proposition, boolean signatureTasvee, boolean signatureFonds, boolean signatureEntreprise) {
        super(proposition, signatureTasvee);
        this.signatureFonds = signatureFonds;
        this.signatureEntreprise = signatureEntreprise;
    }

    public boolean isSignatureFonds() {
        return signatureFonds;
    }

    public void setSignatureFonds(boolean signatureFonds) {
        this.signatureFonds = signatureFonds;
    }

    public boolean isSignatureEntreprise() {
        return signatureEntreprise;
    }

    public void setSignatureEntreprise(boolean signatureEntreprise) {
        this.signatureEntreprise = signatureEntreprise;
    }
}

