package fr.gtm.proxiService2;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.gtm.dao.ClientDao;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.IdClient;

/**
 * Classe permettant de realiser les differents services sur le client :
 * recuperation d'un client, modification d'un client et recuperation d'un
 * compte d'un client. Pour cela les methodes recuperent un flux Json contenant
 * les donnes ainsi que la methode a utiliser, puis renvoie un flux Json
 * contenant la reponse a la requete.
 * 
 * 
 * @author Stagiaire
 *
 */
@Path("clientservice")
public class ClientService {

	ClientDao daoClient = new ClientDao();
	
	/**
	 * Methode de test get pour tester la connectivite entre la WebService et un client 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		Client client = new Client("Monsieur", "Test", "", "", "", "", "", 2);
		return "get it in ClientService..." + client;
	}
	
	/**
	 * Methode recevant un flux Json contetant un IdClient et retournant un client.
	 * Pour cela, elle appelle la methode getClient de la DAO pour recuperer le
	 * client correspondant a l'idClient et pouvoir le retourner sous forme de flux
	 * Json
	 * 
	 * @param client
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getClient(IdClient id) {
		int idClient = id.getIdClient();
		Client monClient = daoClient.getClient(idClient);
		return Response.status(201).entity(monClient).build();
	}
	
}
