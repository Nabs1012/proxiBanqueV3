package fr.gtm.proxiService2;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gtm.dao.ClientDao;
import fr.gtm.dao.CompteDao;
import fr.gtm.domaine.Client;
import fr.gtm.domaine.Compte;

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
@Path("clientService")
public class ClientService {

	ClientDao daoClient = new ClientDao();

	/**
	 * Methode de test get pour tester la connectivite entre la WebService et un
	 * client
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		Client client = new Client("Monsieur", "Test", "", "", "", "", "", 2);
		return "get it in ClientService..." + client;
	}

	/**
	 * Methode recevant un flux Json contetant un Compte partiel (numeroCompte) et
	 * retournant un Compte complet. Pour cela, elle appelle la methode getCompte de
	 * la DAO pour recuperer le compte correspondant au numero de compte et pouvoir
	 * le retourner sous forme de flux Json
	 * 
	 * @param client
	 * @return
	 * @throws IOException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCompte(String JsonCompte) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Compte compte = mapper.readValue(JsonCompte, Compte.class);
		CompteDao daoCompte = new CompteDao();
		Compte monCompte = daoCompte.getCompte(compte.getNumeroCompte());
		String output = mapper.writeValueAsString(monCompte);
		return Response.status(201).entity(output).build();
	}

//	/**
//	 * Methoderecevant un flux Json contetant un Conseiller et retournant la liste
//	 * des clients associés. Pour cela, elle appelle la methode
//	 * getAllClientConseiller de la DAO pour recuperer les clients correspondant au
//	 * conseiller (idConseiller) et pouvoir retourner la liste sous forme de flux
//	 * Json
//	 * 
//	 * @param JsonConseiller
//	 * @return
//	 * @throws JsonParseException
//	 * @throws JsonMappingException
//	 * @throws IOException
//	 */
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response getAllClientConseiller(String JsonConseiller) throws JsonParseException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		Conseiller conseiller = mapper.readValue(JsonConseiller, Conseiller.class);
//		int idConseiller = conseiller.getIdConseiller();
//		List<Client> listeClient = daoClient.getAllClientConseiller(idConseiller);
//		String output = mapper.writeValueAsString(listeClient);
//		return Response.status(201).entity(output).build();
//	}

}
