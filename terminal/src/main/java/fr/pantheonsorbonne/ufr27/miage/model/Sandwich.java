package fr.pantheonsorbonne.ufr27.miage.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Sandwich")
public class Sandwich extends Product{
}
