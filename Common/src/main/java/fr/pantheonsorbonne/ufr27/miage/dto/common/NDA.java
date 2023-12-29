package fr.pantheonsorbonne.ufr27.miage.dto.common;

public abstract class NDA<T> {
    private String titreNDA;
    private T sujet;
    private boolean signatureTasvee;

    public NDA(String titreNDA, T sujet, boolean signatureTasvee) {
        this.sujet = sujet;
        this.signatureTasvee = signatureTasvee;
    }

    // Getters et setters
    public String getTitreNDA() {
        return titreNDA;
    }

    public void setTitreNDA(String titreNDA) {
        this.titreNDA = titreNDA;
    }
    public T getSujet() {
        return sujet;
    }

    public void setSujet(T sujet) {
        this.sujet = sujet;
    }

    public boolean isSignatureTasvee() {
        return signatureTasvee;
    }

    public void setSignatureTasvee(boolean signatureTasvee) {
        this.signatureTasvee = signatureTasvee;
    }

}