package fr.pantheonsorbonne.ufr27.miage.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Bank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bank", nullable = false)
    private int idBank;
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Basic
    @Column(name = "groupName", nullable = false, length = 30)
    private String groupName;

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return idBank == bank.idBank && Objects.equals(name, bank.name) && Objects.equals(groupName, bank.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBank, name, groupName);
    }
}
