package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe appelant le driver et permettant la connexion a la base de donnees.
 * @author Stagiaire
 *
 */
public class ConnectionDao {

	/**
	 * 	Methode retournant un objet de type Connection permettant aux methodes de la couche DAO d'interargir avec la BDD.
	 * @return
	 */
	public static Connection connexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//TODO modifier le login et mdp de connection a la base de donnee
			String url = "jdbc:mysql://localhost:3306/bdd";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
