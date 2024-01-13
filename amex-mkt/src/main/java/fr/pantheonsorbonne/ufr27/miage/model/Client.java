package fr.pantheonsorbonne.ufr27.miage.model;
import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @Column(name = "idClient", nullable = false)
    private Integer idClient;

    private String genre;

    private Integer age;

    private String profession;

    public Client(Integer idClient, String genre, Integer age, String profession) {
        this.idClient = idClient;
        this.genre = genre;
        this.age=age;
        this.profession=profession;
    }

    public Client() {}

    public Integer getIdClient(){return idClient;}

    public void setIdClient(Integer idClient){this.idClient=idClient;}

    public String getGenre(){return genre;}

    public  void setGenre(String genre){this.genre=genre;}

    public Integer getAge(){return age;}

    public void setAge(Integer age){this.age=age;}

    public String getProfession(){return profession;}

    public void setProfession(String profession) {this.profession = profession;}
}
