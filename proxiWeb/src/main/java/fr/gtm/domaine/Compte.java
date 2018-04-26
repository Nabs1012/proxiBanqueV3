package fr.gtm.domaine;

public class Compte {
private int idCompte;
private int numeroCompte;
private double solde;
private int idClient;
private String typeCompte;
/**
 * Constructeur
 * @param idCompte
 * @param numCompte
 * @param solde
 * @param idClient
 * @param typeCompte
 */
public Compte(int idCompte, int numeroCompte, double solde, int idClient, String typeCompte) {
	super();
	this.idCompte = idCompte;
	this.numeroCompte = numeroCompte;
	this.solde = solde;
	this.idClient = idClient;
	this.typeCompte = typeCompte;
}
/**
 * Constructeur vide 
 */
public Compte() {
	super();
}

public Compte(int numeroCompte, double solde, int idClient, String typeCompte) {
	super();
	this.numeroCompte = numeroCompte;
	this.solde = solde;
	this.idClient = idClient;
	this.typeCompte = typeCompte;
}
public int getIdCompte() {
	return idCompte;
}
public void setIdCompte(int idCompte) {
	this.idCompte = idCompte;
}
public int getNumeroCompte() {
	return numeroCompte;
}
public void setNumeroCompte(int numeroCompte) {
	this.numeroCompte = numeroCompte;
}
public double getSolde() {
	return solde;
}
public void setSolde(double solde) {
	this.solde = solde;
}
public int getIdClient() {
	return idClient;
}
public void setIdClient(int idClient) {
	this.idClient = idClient;
}
public String getTypeCompte() {
	return typeCompte;
}
public void setTypeCompte(String typeCompte) {
	this.typeCompte = typeCompte;
}



}
