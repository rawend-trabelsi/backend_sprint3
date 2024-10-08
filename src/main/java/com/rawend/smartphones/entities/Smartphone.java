package com.rawend.smartphones.entities;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

public class Smartphone {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idSmartphone;
private String nomSmartphone;
private Double prixSmartphone;
private Date datecreation; // Changez ici de 'Datecreation' à 'datecreation'

private String couleur;
@ManyToOne
private Type type;


public long getIdSmartphone() {
	return idSmartphone;
}
public void setIdSmartphone(long idSmartphone) {
	this.idSmartphone = idSmartphone;
}
public String getNomSmartphone() {
	return nomSmartphone;
}
public void setNomSmartphone(String nomSmartphone) {
	this.nomSmartphone = nomSmartphone;
}
public Double getPrixSmartphone() {
	return prixSmartphone;
}
public void setPrixSmartphone(Double prixSmartphone) {
	this.prixSmartphone = prixSmartphone;
}
public Date getDatecreation() {
    return datecreation; // Mettez à jour ici
}

public void setDatecreation(Date datecreation) {
    this.datecreation = datecreation; // Mettez à jour ici
}

public String getCouleur() {
	return couleur;
}
public void setCouleur(String couleur) {
	this.couleur = couleur;
}

public Smartphone() {
	super();
	
}
public Smartphone(String nomSmartphone, double prixSmartphone, Date datecreation, String couleur ) {
    this.nomSmartphone = nomSmartphone;
    this.prixSmartphone = prixSmartphone;
    this.datecreation = datecreation;
    this.couleur = couleur;

}
@Override
public String toString() {
	return "Smartphone [idSmartphone=" + idSmartphone + ", nomSmartphone=" + nomSmartphone + ", prixSmartphone="
			+ prixSmartphone + ", Datecreation=" + datecreation + ", couleur=" + couleur +  "]";
}
public Type getType() {
	return type;
}
public void setType(Type type) {
	this.type = type;
}



}
