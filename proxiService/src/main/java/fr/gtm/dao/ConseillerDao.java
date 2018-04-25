package fr.gtm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.domaine.Conseiller;

/**
 * Classe contenant une partie du CRUD du conseiller. Elle permet notamment de
 * recuperer un conseiller de la BDD a partir de son ID.
 * 
 * @author Stagiaire
 *
 */
public class ConseillerDao {

	/**
	 * Methode permettant la recuperation d'un conseiller dans la BDD a partir de
	 * son ID. Une fois le conseiller recupere, ses donnes sont implementees dans un
	 * nouvel objet conseiller qui peut ainsi etre renvoye.
	 * 
	 * @param idConseiller
	 * @return
	 */
	public Conseiller getClient(int idConseiller) {
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from Conseiller where idConseiller = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, idConseiller);
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery(s);
			// Attribution des valeurs a un nouveau conseiller a renvoyer
			Conseiller monConseiller = new Conseiller();
			rs.next();
			monConseiller.setIdConseiller(rs.getInt("idConseiller"));
			monConseiller.setNom(rs.getString("nom"));
			monConseiller.setPrenom(rs.getString("prenom"));
			return monConseiller;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
