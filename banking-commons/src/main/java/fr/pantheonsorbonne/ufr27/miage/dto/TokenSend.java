package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TokenSend {
    String email;
    String bankName;
    String token;

    public TokenSend(String email, String bankName, String token) {
        this.email = email;
        this.bankName = bankName;
        this.token = token;
    }

    public String getMail() {
        return email;
    }

    public String getIdBank() {
        return bankName;
    }

    public String getToken() {
        return token;
    }


}
