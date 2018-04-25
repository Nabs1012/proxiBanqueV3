package fr.gtm.service;

import fr.gtm.domaine.Client;

public class main {

	public static void main(String[] args) {

		ClientService serviceClient = new ClientService();
		Client client = new Client();
		client.setIdClient(1);
		client = serviceClient.getClient(client);
		System.out.println(client.getNom()+client.getIdClient());
	}

}
