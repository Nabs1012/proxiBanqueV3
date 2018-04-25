package fr.gtm.domaine;

public class Login {
	private int idLogin;
	private String login;
	private String motDePasse;
	private int idConseiller;

	/**
	 * Constructeur
	 * 
	 * @param idLogin
	 * @param login
	 * @param motDePasse
	 * @param idConseiller
	 */
	public Login(String login, String motDePasse, int idConseiller) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.idConseiller = idConseiller;
	}

	/**
	 * Constructeur vide
	 */
	public Login() {
		super();
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

}
