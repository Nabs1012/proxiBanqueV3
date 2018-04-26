package fr.gtm.service;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.dao.CompteDao;
import fr.gtm.domaine.Compte;

/**
 * Classe permettant de tester toutes les methodes de la classe
 * GestionCompteService.
 * 
 * @author Stagiaire
 *
 */
public class GestionCompteServiceTest {

	private double montant;
	private double soldeCredit;
	private double soldeDebit;
	private double resultat;
	private boolean reponse;
	private Compte compteCredit;
	private Compte compteDebit;
	private Compte compteTest;
	private GestionCompteService serviceTeste;

	/**
	 * Avant l'integralite des tests la methode creer en BDD les variables
	 * utilisees.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Compte comptecredit = new Compte(123, 0, 1, "courant");
		Compte comptedebit = new Compte(234, 0, 1, "epargne");
		CompteDao daoCompte = new CompteDao();
		daoCompte.createCompte(comptecredit);
		daoCompte.createCompte(comptedebit);
		comptecredit = daoCompte.getCompte(comptecredit.getNumeroCompte());
		comptedebit = daoCompte.getCompte(comptedebit.getNumeroCompte());
	}

	/**
	 * Apres l'integralite des tests la methode supprime les differentes variables
	 * creer dans la BDD.
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CompteDao daoCompte = new CompteDao();
		Compte comptecredit = daoCompte.getCompte(123);
		Compte comptedebit = daoCompte.getCompte(234);
		daoCompte.deleteCompte(comptecredit);
		daoCompte.deleteCompte(comptedebit);
	}

	/**
	 * Avant chaques tests la methode set les etats des variables utilisees.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUpBeforeTest() throws Exception {
		CompteDao daoCompte = new CompteDao();
		compteCredit = daoCompte.getCompte(123);
		compteDebit = daoCompte.getCompte(234);
		montant = 5000;
		soldeCredit = 10000;
		soldeDebit = 5000;
		compteCredit.setSolde(soldeCredit);
		compteDebit.setSolde(soldeDebit);
		serviceTeste = new GestionCompteService();
		reponse = false;
	}

	/**
	 * Test de la methode credit.
	 */
	@Test
	public void credit() {
		compteTest = serviceTeste.credit(compteCredit, montant);
		resultat = soldeCredit + montant;
		assertThat(compteTest.getSolde(), IsEqual.equalTo(resultat));
	}

	/**
	 * Test de la methode debit
	 */
	@Test
	public void debit() {
		compteTest = serviceTeste.debit(compteDebit, montant);
		resultat = soldeDebit - montant;
		assertThat(compteTest.getSolde(), IsEqual.equalTo(resultat));
	}

	/**
	 * Test de la methode virementCompteACompte
	 */
	@Test
	public void virementCompteACompte() {
		reponse = serviceTeste.virementCompteACompte(compteCredit, compteDebit, montant);
		assertThat(reponse, IsEqual.equalTo(true));
	}
}
