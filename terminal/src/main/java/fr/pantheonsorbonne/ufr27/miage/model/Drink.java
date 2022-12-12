package fr.pantheonsorbonne.ufr27.miage.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Drink")
public class Drink extends Product{
}
