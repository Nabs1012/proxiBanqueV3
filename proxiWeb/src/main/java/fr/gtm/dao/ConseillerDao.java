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
	
	Conseiller monConseiller = new Conseiller();
	
	/**
	 * Methode permettant de creer un conseiller en BDD.
	 * @param conseiller
	 * @return
	 */
	public boolean createConseiller(Conseiller conseiller) {
		int i = 0;
		boolean b = false;
		try {
			// Preparation du string pour la prepared statement
			String s = "INSERT INTO `client`(`nom`, `prenom`) VALUES (?, ?)";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setString(1, conseiller.getNom());
			pstmt.setString(2, conseiller.getPrenom());
			// Execution de la prepared statement
			i = pstmt.executeUpdate();
			if (i != 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * Methode permettant de supprimer un conseiller en BDD.
	 * @param client
	 * @return
	 */
	public boolean deleteConseiller(Conseiller conseiller) {
		int i = 0;
		boolean b = false;
		try {
			// Suppression des comptes associ�s
			// Preparation du string pour la prepared statement
			String s = "DELETE from conseiller where idConseiller = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, conseiller.getIdConseiller());
			// Execution de la prepared statement
			i = pstmt.executeUpdate();
			if (i != 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * Methode permettant de modifier un conseiller.
	 * @param client
	 * @return
	 */
	public Conseiller updateClient(Conseiller conseiller) {
		try {
			// Preparation du string pour la prepared statement
			String s = "UPDATE client set nom = ?, prenom = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setString(1, conseiller.getNom());
			pstmt.setString(2, conseiller.getPrenom());
			// Execution de la prepared statement
			pstmt.executeUpdate();

			// Preparation d'un deuxieme string pour la seconde prepared statement
			String s2 = "Select * from conseiller where idConseiller = ?";
			PreparedStatement pstmt2 = ConnectionDao.connexion().prepareStatement(s2);
			// Implementation des valeurs dans la prepared statement
			pstmt2.setInt(1, conseiller.getIdConseiller());
			// Execution de la prepared statement
			ResultSet rs = pstmt2.executeQuery();

			// Attribution des valeurs a un nouveau client a renvoyer
			rs.first();
			monConseiller.setIdConseiller(rs.getInt("idClient"));
			monConseiller.setNom(rs.getString("nom"));
			monConseiller.setPrenom(rs.getString("prenom"));
			return monConseiller;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode permettant la recuperation d'un conseiller dans la BDD a partir de
	 * son ID. Une fois le conseiller recupere, ses donnes sont implementees dans un
	 * nouvel objet conseiller qui peut ainsi etre renvoye.
	 * 
	 * @param idConseiller
	 * @return
	 */
	public Conseiller getConseiller(int idConseiller) {
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from Conseiller where idConseiller = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, idConseiller);
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery();
			// Attribution des valeurs a un nouveau conseiller a renvoyer
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
