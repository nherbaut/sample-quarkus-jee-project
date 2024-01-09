package fr.pantheonsorbonne.ufr27.miage.dto;

public class InformationPayment {
    Client client;
    float price;
    String cardNumber;
    int idTicket;

    public Client getClient() { return client; }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
}
