package fr.gtm.service;

import fr.gtm.domaine.Client;

public class main {

	public static void main(String[] args) {
		
		ClientService serviceClient = new ClientService();
		Client monClient = new Client();
		monClient.setIdClient(1);
		Client client = serviceClient.getClient(monClient);
		System.out.println(client);
		
	}

}
