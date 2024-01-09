package fr.pantheonsorbonne.ufr27.miage.dto;

public class Client {

    int idClient;
    Genre genre;
    int age;
    String profession;

    public Client(int idClient, Genre genre, int age, String profession) {
        this.idClient = idClient;
        this.genre = genre;
        this.age = age;
        this.profession = profession;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
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
