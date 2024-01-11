package fr.pantheonsorbonne.ufr27.miage.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public record NewCustomer(String fName, String lName, String address, String email, String pwd) {
}
