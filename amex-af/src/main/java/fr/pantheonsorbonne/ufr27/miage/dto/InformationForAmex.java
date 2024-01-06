package fr.pantheonsorbonne.ufr27.miage.dto;

public class InformationForAmex {
    int idClient;
    float price;

    public InformationForAmex(int idClient, float price) {
        this.idClient = idClient;
        this.price = price;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
