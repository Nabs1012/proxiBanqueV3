package fr.gtm.domaine;

/**
 * @author Stagiaire POJO Client
 */
public class Client {
	private int idClient;
	private String nom;
	private String prenom;
	private String rue;
	private String codePostal;
	private String ville;
	private String email;
	private String telephone;
	private int idConseiller;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 * @param prenom
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param email
	 * @param telephone
	 * @param idConseiller
	 */
	public Client(String nom, String prenom, String rue, String codePostal, String ville, String email, String telephone, int idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.email = email;
		this.telephone = telephone;
		this.idConseiller = idConseiller;
	}

	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", email=" + email + ", telephone=" + telephone + "]";
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

}
