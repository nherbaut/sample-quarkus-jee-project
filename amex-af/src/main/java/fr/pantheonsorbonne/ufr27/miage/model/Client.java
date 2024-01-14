package fr.pantheonsorbonne.ufr27.miage.model;

import fr.pantheonsorbonne.ufr27.miage.dto.Genre;
import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @Column(name = "idClient", nullable = false)
    private int idClient;

    @Column(name = "Genre", nullable = false)
    private String genre;

    @Column(name = "Age", nullable = false)
    private int age;

    @Column(name = "Profession", nullable = false, length = 45)
    private String profession;

    public Client(int idClient, String genre, int age, String profession) {
        this.idClient = idClient;
        this.genre = genre;
        this.age = age;
        this.profession = profession;
    }

    public Client() {

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}