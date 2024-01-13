package top.nextnet.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Token {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_token", nullable = false)
    private int idToken;
    @Basic
    @Column(name = "id_bank", nullable = false)
    private int idBank;
    @Basic
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "token", nullable = false, length = 255)
    private String token;

    public Token(int idbank, int idaccount, String token) {
        this.idBank = idbank;
        this.idAccount = idaccount;
        this.token = token;
    }

    public Token() {

    }

    public int getIdToken() {
        return idToken;
    }

    public void setIdToken(int idToken) {
        this.idToken = idToken;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return idToken == token1.idToken && idBank == token1.idBank && idAccount == token1.idAccount && Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idToken, idBank, idAccount, token);
    }
}
