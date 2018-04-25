package fr.gtm.domaine;

/**
 * POJO IdClient
 * @author Stagiaire
 *
 */
public class IdClient {

	private int idClient;

	
	/**
	 * Constructeur
	 * @param idClient
	 */
	public IdClient(int idClient) {
		super();
		this.idClient = idClient;
	}

	/**
	 * Constructeur vide
	 */
	public IdClient() {
		super();
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
