package fr.gtm.domaine;

public class Conseiller {
	private int idConseiller;
	private String nom;
	private String prenom;

	/**
	 * Constructeur
	 * 
	 * @param idConseiller
	 * @param nom
	 * @param prenom
	 */
	public Conseiller(int idConseiller, String nom, String prenom) {
		super();
		this.idConseiller = idConseiller;
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * Constructeur vide
	 */
	public Conseiller() {
		super();
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
