package fr.pantheonsorbonne.ufr27.miage.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Secret_Password")
public class SecretPassword {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_Id", nullable = false)
    private Account account;

    @NotNull
    @Column(name = "secret_password", nullable = false)
    private Integer secretPassword;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getSecretPassword() {
        return secretPassword;
    }

    public void setSecretPassword(Integer secretPassword) {
        this.secretPassword = secretPassword;
    }

}