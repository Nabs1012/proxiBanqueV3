package fr.gtm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.domaine.Client;

/**
 * Classe contenant une partie du CRUD du client. Elle permet de recuperer un
 * client dans la base de donnee a l'aide de son ID, de le modifier, ainsi que
 * de recuperer ses comptes. Une methode permet egalement de recuperer tous les
 * clients d'un meme conseiller.
 * 
 * @author Stagiaire
 *
 */
public class ClientDao {

	// Création d'un client utilise dans toutes les methodes
	Client monClient = new Client();

	/**
	 * Methode qui va chercher un client dans la BDD grace a l'ID client reçu et
	 * retourne un client.
	 * 
	 * @param idClient
	 * @return
	 */
	public Client getClient(int idClient) {
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from Client where idClient = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, idClient);
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery(s);
			// Attribution des valeurs a un nouveau client a renvoyer
			rs.next();
			monClient.setIdClient(rs.getInt("idClient"));
			monClient.setRue(rs.getString("rue"));
			monClient.setNom(rs.getString("nom"));
			monClient.setPrenom(rs.getString("prenom"));
			monClient.setCodePostal(rs.getString("codePostal"));
			monClient.setVille(rs.getString("ville"));
			monClient.setTelephone(rs.getString("telephone"));
			monClient.setEmail(rs.getString("email"));
			monClient.setIdConseiller(rs.getInt("idConseiller"));
			return monClient;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode permettant de modifier les valeurs d'un client dans la BDD. Elle
	 * commence par modifier dans la BDD puis recupere la nouvelle version du client
	 * pour pouvoir la renvoyer.
	 * 
	 * @param client
	 * @return
	 */
	public Client updateClient(Client client) {
		try {
			// Preparation du string pour la prepared statement
			String s = "UPDATE client set nom = ?, prenom = ?, adresse = ?, codePostal = ?, ville = ?, email = ?, telephone = ?, idConseiller = ? where idClient = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setString(1, client.getNom());
			pstmt.setString(2, client.getPrenom());
			pstmt.setString(3, client.getRue());
			pstmt.setString(4, client.getCodePostal());
			pstmt.setString(5, client.getVille());
			pstmt.setString(6, client.getEmail());
			pstmt.setString(7, client.getTelephone());
			pstmt.setInt(8, client.getIdConseiller());
			// Execution de la prepared statement
			pstmt.executeUpdate(s);

			// Preparation d'un deuxieme string pour la seconde prepared statement
			String s2 = "Select * from client where idClient = ?";
			PreparedStatement pstmt2 = ConnectionDao.connexion().prepareStatement(s2);
			// Implementation des valeurs dans la prepared statement
			pstmt2.setInt(1, client.getIdClient());
			// Execution de la prepared statement
			ResultSet rs = pstmt2.executeQuery(s);

			// Attribution des valeurs a un nouveau client a renvoyer
			rs.first();
			monClient.setIdClient(rs.getInt("idClient"));
			monClient.setNom(rs.getString("nom"));
			monClient.setPrenom(rs.getString("prenom"));
			monClient.setRue(rs.getString("rue"));
			monClient.setCodePostal(rs.getString("codePostal"));
			monClient.setVille(rs.getString("ville"));
			monClient.setEmail(rs.getString("email"));
			monClient.setTelephone(rs.getString("telephone"));
			monClient.setIdConseiller(rs.getInt("idConseiller"));
			return monClient;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode retournant la liste de tous les clients d'un conseiller grace a son ID.
	 * @param idConseiller
	 * @return
	 */
	public List<Client> getAllClientConseiller(int idConseiller) {
		List<Client> listClient = new ArrayList<Client>();
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from Client where idConseiller = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, idConseiller);
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery(s);
			// Lecture des resultats de la requete et insertion dans la liste pour chaque boucle
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setRue(rs.getString("rue"));
				client.setCodePostal(rs.getString("codePostal"));
				client.setVille(rs.getString("ville"));
				client.setEmail(rs.getString("email"));
				client.setTelephone(rs.getString("telephone"));
				client.setIdConseiller(rs.getInt("idConseiller"));
				listClient.add(client);
			}
			return listClient;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
