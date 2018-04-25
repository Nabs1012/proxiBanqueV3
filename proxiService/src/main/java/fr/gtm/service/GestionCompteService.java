package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.dao.CompteDao;
import fr.gtm.domaine.Compte;

/**
 * Classe permettant de realiser les differents services sur les comptes :
 * recuperation de la totalite des comptes present en BDD, realisation d'un
 * debit sur un compte donne, realisation d'un credit sur un compte donne,
 * realisation d'un virement d'un compte a un autre. Pour cela les methodes
 * recuperent un flux Json contenant les donnes ainsi que la methode a utiliser,
 * puis renvoie un flux Json contenant la reponse a la requete.
 * 
 * @author Stagiaire
 *
 */
public class GestionCompteService {

	CompteDao daoCompte = new CompteDao();

	/**
	 * Methode permettant de recuperer tous les comptes prensent en BDD. Pour cela
	 * elle appelle la DAO et renvoie la liste de compte sous forme d'un flux Json.
	 * 
	 * @return
	 */
	public List<Compte> getAllCompte() {

		List<Compte> listeCompte = new ArrayList<Compte>();
		listeCompte = daoCompte.getAllCompte();
		return listeCompte;

	}

	/**
	 * Methode qui credite le montant donne par la requte sur le compte renseigne
	 * par la requete. Pour cela, elle recupere la totalité des informations liées
	 * au compte donne avant d'en modifier le solde dans la BDD, puis de renvoyer
	 * les nouvelles informations du compte.
	 * 
	 * @param compte
	 * @param montant
	 * @return
	 */
	public Compte credit(Compte compte, double montant) {
		Compte monCompte = daoCompte.getCompte(compte.getIdClient(), compte.getTypeCompte());
		monCompte.setSolde(monCompte.getSolde() + montant);
		return monCompte = daoCompte.updateSoldeCompte(monCompte);
	}

	/**
	 * Methode qui debite le montant donne par la requte sur le compte renseigne par
	 * la requete. Pour cela, elle recupere la totalité des informations liées au
	 * compte donne avant d'en modifier le solde dans la BDD, puis de renvoyer les
	 * nouvelles informations du compte.
	 * 
	 * @param compte
	 * @param montant
	 * @return
	 */
	public Compte debit(Compte compte, double montant) {
		Compte monCompte = daoCompte.getCompte(compte.getIdClient(), compte.getTypeCompte());
		monCompte.setSolde(monCompte.getSolde() - montant);
		return monCompte = daoCompte.updateSoldeCompte(monCompte);
	}

	/**
	 * Methode qui realise un virement de compte à compte. Pour cela, elle credite
	 * le compte a crediter du montant donne par la requete puis debite le compte a
	 * debiter de ce meme montant. Si un probleme survient, la methode retourne
	 * false. Sinon le virement s'est bien effectue et elle retourne true.
	 * 
	 * @param compteCredit
	 * @param compteDebit
	 * @param montant
	 * @return
	 */
	public boolean virementCompteACompte(Compte compteCredit, Compte compteDebit, double montant) {
		Compte compteDebit2 = this.debit(compteDebit, montant);
		Compte compteCredit2 = this.credit(compteCredit, montant);
		if (compteCredit2.equals(null) || compteDebit2.equals(null)) {
			return false;
		} else {
			return true;
		}
	}
}
