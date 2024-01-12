package top.nextnet.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Password {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_password", nullable = false)
    private int idPassword;
    @Basic
    @Column(name = "id_account", nullable = false)
    private int idAccount;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public int getIdPassword() {
        return idPassword;
    }

    public void setIdPassword(int idPassword) {
        this.idPassword = idPassword;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return idPassword == password1.idPassword && idAccount == password1.idAccount && Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassword, idAccount, password);
    }
}
