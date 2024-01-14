package fr.pantheonsorbonne.ufr27.miage.dto;

import java.util.Objects;

public class InformationForAmex {

    Client client;
    float price;

    public InformationForAmex(Client client, float price) {
        this.client = client;
        this.price = price;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        return Float.compare(that.price, price) == 0 && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, price);
    }
}