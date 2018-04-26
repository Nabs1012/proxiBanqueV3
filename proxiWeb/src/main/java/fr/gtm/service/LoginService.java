package fr.gtm.service;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.dao.LoginDao;
import fr.gtm.domaine.Conseiller;
import fr.gtm.domaine.Login;

/**
 * Classe contenant le service de verification de la classe Login.
 * 
 * @author Stagiaire
 *
 */
public class LoginService {

	/**
	 * Methode permettant de verifier si le login envoyer correspond a un login en
	 * BDD. Si c'est le cas, la methode renvoie un objet conseiller dont les etats
	 * correspondes a ceux de celui possedant le login envoye. Sinon, elle renvoie
	 * un conseiller nul.
	 * 
	 * @param login
	 * @return
	 */
	public Conseiller verifLogin(Login login) {
		//Creation des variables necessaires a l'appel de la DAO
		LoginDao daoLogin = new LoginDao();
		ConseillerDao daoConseiller = new ConseillerDao();
		//Creation de la variable conseiller a retourner
		Conseiller monConseiller = new Conseiller();
		//Verification du login
		Login monLogin = daoLogin.verificationLogin(login);
		if (monLogin != null) {//Si le login existe en BDD -> on va chercher le conseiller a qui appartient le login
			monConseiller = daoConseiller.getConseiller(monLogin.getIdConseiller());
		}else {//Sinon on renvoie un conseiller nul
			monConseiller = null;
		}
		return monConseiller;
	}

}
