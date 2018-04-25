package fr.gtm.service;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
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

	/**
	 * Avant les tests on instancie les differentes classes appelees pour realiser
	 * les differents tests. On creer aussi les variables necessaires.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CompteDao daoCompte = new CompteDao();
		Compte comptecredit = new Compte(10058, 10000, 1, "courant");
		Compte comptedebit = new Compte(20058, 5000, 1, "epargne");
		daoCompte.createCompte(comptecredit);
		daoCompte.createCompte(comptedebit);
		comptecredit = daoCompte.getCompte(comptecredit.getIdClient(), comptecredit.getTypeCompte());
		comptedebit = daoCompte.getCompte(comptedebit.getIdClient(), comptedebit.getTypeCompte());
		GestionCompteService serviceTeste = new GestionCompteService();
		Compte compteTest = new Compte();
	}

	/**
	 * Après les tests on supprime les différentes variables creer dans la base de
	 * donnees.
	 * 
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test de la methode credit.
	 */
	@Test
	public void credit() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test de la methode debit
	 */
	@Test
	public void debit() {
		
		fail("Not yet implemented");
	}
	
	/**
	 * Test de la methode virementCompteACompte
	 */
	@Test
	public void virementCompteACompte() {
		
		fail("Not yet implemented");
	}
}
