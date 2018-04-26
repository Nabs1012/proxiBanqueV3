
package fr.gtm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.gtm.domaine.Compte;

/**
 * Classe contenant des methodes pour recuperer des comptes presents dans la
 * BDD. Elle contient des methodes permettant de recuperer un compte donne ou la
 * totalite des comptes de la BDD.
 * 
 * @author Stagiaire
 *
 */
public class CompteDao {

	/**
	 * Methode permettant de creer un compte en BDD. Pour cela, la methode prend en
	 * entree un compte et l'insere en BDD. Si tout se passe bien elle renvoie true
	 * sinon elle renvoie False.
	 * 
	 * @param client
	 * @return
	 */
	public boolean createCompte(Compte compte) {
		int i = 0;
		boolean b = false;
		try {
			// Preparation du string pour la prepared statement
			String s = "INSERT INTO `client`(`numeroCompte`, `solde`, `typeCompte`, `idClient`) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getNumeroCompte());
			pstmt.setDouble(2, compte.getSolde());
			pstmt.setString(3, compte.getTypeCompte());
			pstmt.setInt(4, compte.getIdClient());
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
	 * Methode permettant de supprimer un compte de la BDD. Pour cela, la methode
	 * supprime le compte. Si l'operation se passe correctement la methode renvoie
	 * true sinon elle renvoie false.
	 * 
	 * @param client
	 * @return
	 */
	public boolean deleteCompte(Compte compte) {
		int i = 0;
		boolean b = false;
		try {
			// Suppression des comptes associ�s
			// Preparation du string pour la prepared statement
			String s = "DELETE from compte where idCompte = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getIdCompte());
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
	 * Methode qui permet de modifier la valeur du solde d'un compte en BDD puis
	 * renvoie le compte modifier. Pour cela, elle modifie la valeur du solde en BDD
	 * grace a l'ID du compte qui est envoyer dans la requete puis implemente les
	 * nouvelles informations dans un objet Compte qu'elle renvoie ensuite.
	 * 
	 * @param compte
	 * @return
	 */
	public Compte updateSoldeCompte(Compte compte) {
		try {
			// Preparation du string pour la prepared statement
			String s = "UPDATE compte set solde = ? where idCompte = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getIdCompte());
			// Execution de la prepared statement
			pstmt.executeUpdate();

			// Preparation d'un deuxieme string pour la seconde prepared statement
			String s2 = "Select * from compte where idClient = ?";
			PreparedStatement pstmt2 = ConnectionDao.connexion().prepareStatement(s2);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getIdCompte());
			// Execution de la prepared statement
			ResultSet rs = pstmt2.executeQuery();

			// Attribution des valeurs a un nouveau client a renvoyer
			Compte monCompte = new Compte();
			rs.first();
			monCompte.setIdClient(rs.getInt("idClient"));
			monCompte.setIdCompte(rs.getInt("idCompte"));
			monCompte.setNumeroCompte(rs.getInt("numeroCompte"));
			monCompte.setSolde(rs.getDouble("solde"));
			monCompte.setTypeCompte(rs.getString("typeCompte"));
			return monCompte;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode qui permet de modifier 'un compte en BDD puis renvoie le compte
	 * modifier. Pour cela, elle modifie les differentes valeurs en BDD grace a l'ID
	 * du compte qui est envoyer dans la requete puis implemente les nouvelles
	 * informations dans un objet Compte qu'elle renvoie ensuite.
	 * 
	 * @param compte
	 * @return
	 */
	public Compte updateCompte(Compte compte) {
		try {
			// Preparation du string pour la prepared statement
			String s = "UPDATE compte set solde = ?, numeroCompte = ?, typeCompte = ?, idClient = ? where idCompte = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getIdCompte());
			pstmt.setInt(2, compte.getNumeroCompte());
			pstmt.setString(3, compte.getTypeCompte());
			pstmt.setInt(4, compte.getIdClient());
			// Execution de la prepared statement
			pstmt.executeUpdate();

			// Preparation d'un deuxieme string pour la seconde prepared statement
			String s2 = "Select * from compte where idClient = ?";
			PreparedStatement pstmt2 = ConnectionDao.connexion().prepareStatement(s2);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, compte.getIdCompte());
			// Execution de la prepared statement
			ResultSet rs = pstmt2.executeQuery();

			// Attribution des valeurs a un nouveau client a renvoyer
			Compte monCompte = new Compte();
			rs.first();
			monCompte.setIdClient(rs.getInt("idClient"));
			monCompte.setIdCompte(rs.getInt("idCompte"));
			monCompte.setNumeroCompte(rs.getInt("numeroCompte"));
			monCompte.setSolde(rs.getDouble("solde"));
			monCompte.setTypeCompte(rs.getString("typeCompte"));
			return monCompte;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode qui renvoie le compte d'un client grace a son Id et au type de compte
	 * desire. Pour cela, on recupere le compte possedant l'Id client et le type de
	 * compte dans la BDD correspondant a la requete puis on implemente les
	 * informations recuperees dans un nouvel objet Compte qui est renvoye.
	 * 
	 * @param idClient
	 * @param typeCompte
	 * @return
	 */
	public Compte getCompte(int idClient, String typeCompte) {
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from compte where idClient = ? && typeCompte = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setInt(1, idClient);
			pstmt.setString(2, typeCompte);
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery();

			// Attribution des valeurs a un nouveau compte a renvoyer
			Compte compte = new Compte();
			rs.next();
			compte.setIdCompte(rs.getInt("idCompte"));
			compte.setNumeroCompte(rs.getInt("numeroCompte"));
			compte.setSolde(rs.getDouble("solde"));
			compte.setTypeCompte(rs.getString("typeCompte"));
			compte.setIdClient(rs.getInt("idClient"));
			return compte;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Methode qui recupere tous les comptes courants et tous les comptes epargnes
	 * de la base de donnee et les renvoie dans une liste qui contient d'abord les
	 * comptes courant suivie des comptes epargnes.
	 * 
	 * @return
	 */
	public List<Compte> getAllCompte() {
		List<Compte> listCompte = new ArrayList<Compte>();
		try {
			// Recuperation des comptes courant
			// Preparation du string pour la prepared statement
			String s = "Select * from compte where typeCompte = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setString(1, "courant");
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery();
			// Lecture des resultats de la requete et insertion dans la liste pour chaque
			// boucle
			while (rs.next()) {
				Compte compte = new Compte();
				compte.setIdCompte(rs.getInt("idCompte"));
				compte.setNumeroCompte(rs.getInt("numeroCompte"));
				compte.setSolde(rs.getDouble("solde"));
				compte.setTypeCompte(rs.getString("typeCompte"));
				compte.setIdClient(rs.getInt("idClient"));
				listCompte.add(compte);
			}

			// Recuperation des comptes epargne
			// Preparation du string pour la prepared statement
			String s2 = "Select * from compte where typeCompte = ?";
			PreparedStatement pstmt2 = ConnectionDao.connexion().prepareStatement(s2);
			// Implementation des valeurs dans la prepared statement
			pstmt2.setString(1, "epargne");
			// Execution de la prepared statement
			ResultSet rs2 = pstmt2.executeQuery();
			// Lecture des resultats de la requete et insertion dans la liste pour chaque
			// boucle
			while (rs2.next()) {
				Compte compte = new Compte();
				compte.setIdCompte(rs2.getInt("idCompte"));
				compte.setNumeroCompte(rs2.getInt("numeroCompte"));
				compte.setSolde(rs2.getDouble("solde"));
				compte.setTypeCompte(rs2.getString("typeCompte"));
				compte.setIdClient(rs2.getInt("idClient"));
				listCompte.add(compte);
			}
			return listCompte;
		} catch (SQLException e) {
			return null;
		}
	}

}
