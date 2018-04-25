package fr.gtm.domaine;

public class Compte {
	private int idCompte;
	private int numCompte;
	private int solde;
	private int idClient;
	String typeCompte;

	/**
	 * Constructeur
	 * 
	 * @param idCompte
	 * @param numCompte
	 * @param solde
	 * @param idClient
	 * @param typeCompte
	 */
	public Compte(int idCompte, int numCompte, int solde, int idClient, String typeCompte) {
		super();
		this.idCompte = idCompte;
		this.numCompte = numCompte;
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

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
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
