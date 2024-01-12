package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DemandeAuthorisation {
    String texte;
    User user;
    public DemandeAuthorisation(User user, String texte){
        this.user = user;
        this.texte = texte;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setTexte(String texte){
        this.texte = texte;
    }
    public String getTexte(){
        return this.texte;
    }
}
