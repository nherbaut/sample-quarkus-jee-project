package fr.pantheonsorbonne.ufr27.miage.dto;

public class ClientDTO {

    Integer client_id;

    public ClientDTO(){

    }

    public ClientDTO(Integer client_id){
        this.client_id = client_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
}
