package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationForAmex that = (InformationForAmex) o;
        return idClient == that.idClient && Float.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, price);
    }
}
