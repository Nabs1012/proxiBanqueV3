package fr.gtm.service;

import java.util.List;

import fr.gtm.dao.ClientDao;
import fr.gtm.dao.CompteDao;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.Compte;
import fr.gtm.domaine.Conseiller;

/**
 * Classe permettant de realiser les differents services sur le client :
 * recuperation d'un client, modification d'un client et recuperation d'un
 * compte d'un client.
 * 
 * @author Stagiaire
 *
 */

public class ClientService {

	// Instanciation du service DAO pour le client
	ClientDao daoClient = new ClientDao();

	/**
	 * Methode recevant un IdClient et retournant un client. Pour cela, elle appelle
	 * la methode getClient de la DAO pour recuperer le client correspondant a
	 * l'idClient et pouvoir le retourner.
	 * 
	 * @param client
	 * @return
	 */
	public Client getClient(Client client) {
		int idClient = client.getIdClient();
		Client monClient = daoClient.getClient(idClient);
		return monClient;
	}

	/**
	 * Methode recevant un IdConseiller et retournant la liste de client du
	 * conseiller correspondant a cet ID. Pour cela, elle appelle la methode
	 * getAllClientConseiller de la DAO pour recuperer la liste des clients du
	 * conseiller possedant l'Id envoye. Elle renvoie ensuite la liste de client.
	 * 
	 * @param conseiller
	 * @return
	 */
	public List<Client> getAllClientConseiller(Conseiller conseiller) {
		int idConseiller = conseiller.getIdConseiller();
		List<Client> listeClient = daoClient.getAllClientConseiller(idConseiller);
		return listeClient;
	}

	/**
	 * Methode recevant un client contenant les nouvelles informations a implementer
	 * dans la BDD et retournant le client une fois les informations modifiees. Pour
	 * cela, la methode appelle la methode updateClient de la DAO pour realiser les
	 * modifications en BDD.
	 * 
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client) {
		Client monClient = daoClient.updateClient(client);
		return monClient;
	}

	public Compte getCompte(Compte compte) {
		CompteDao daoCompte = new CompteDao();
		Compte monCompte = daoCompte.getCompte(compte.getNumeroCompte());
		return monCompte;
	}

}
