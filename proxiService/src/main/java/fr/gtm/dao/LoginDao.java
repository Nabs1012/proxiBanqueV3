package fr.gtm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gtm.domaine.Login;

/**
 * Classe permettant la verification d'un login par la comparaison du login et
 * mot de passe reçu et ceux presents dans la BDD.
 * 
 * @author Stagiaire
 *
 */
public class LoginDao {

	/**
	 * Methode comparant le login et le mot de passe reçu avec ceux present en BDD.
	 * S'il y a correspondance pour les deux en meme temps pour un meme element de
	 * la table login en BDD, la methode renvoie l'element login correspondant par
	 * la creation d'un nouvel objet login implemente, dans le cas contraire, la
	 * methode renvoie un login null.
	 * 
	 * @param login
	 * @return
	 */
	public Login VerificationLogin(Login login) {
		try {
			// Preparation du string pour la prepared statement
			String s = "Select * from conseiller inner Join Login on conseiller.idConseiller = login.idConseiller where login = ? && motDePasse = ?";
			PreparedStatement pstmt = ConnectionDao.connexion().prepareStatement(s);
			// Implementation des valeurs dans la prepared statement
			pstmt.setString(1, login.getLogin());
			pstmt.setString(2, login.getMotDePasse());
			// Execution de la prepared statement
			ResultSet rs = pstmt.executeQuery(s);
			// Attribution des valeurs a un nouveau login a renvoyer
			Login monLogin = new Login();
			rs.next();
			monLogin.setIdLogin(rs.getInt("idLogin"));
			monLogin.setLogin(rs.getString("login"));
			monLogin.setMotDePasse(rs.getString("motDePasse"));
			monLogin.setIdConseiller(rs.getInt("idConseiller"));
			return monLogin;
		} catch (SQLException e) {
			return null;
		}
	}
}
