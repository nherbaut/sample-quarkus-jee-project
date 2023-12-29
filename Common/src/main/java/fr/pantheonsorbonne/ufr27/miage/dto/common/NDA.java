package fr.pantheonsorbonne.ufr27.miage.dto.common;

public abstract class NDA<T> {
    private T sujet;
    private boolean signatureTasvee;

    public NDA( T sujet, boolean signatureTasvee) {
        this.sujet = sujet;
        this.signatureTasvee = signatureTasvee;
    }

    // Getters et setters

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