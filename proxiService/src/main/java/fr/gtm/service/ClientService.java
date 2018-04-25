package fr.gtm.service;

import fr.gtm.dao.ClientDao;
import fr.gtm.domaine.Client;

public class ClientService {

	ClientDao daoClient = new ClientDao();
	
	public Client getClient(Client client) {
		Client monClient = daoClient.getClient(client.getIdClient());
		return monClient;
	}
	
}
