package fr.gtm.service;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.gtm.dao.CompteDao;
import fr.gtm.domaine.Compte;

/**
 * Classe permettant de tester toutes les methodes de la classe
 * GestionCompteService avec des parametres.
 * @author Stagiaire
 *
 */
@RunWith(Parameterized.class)
public class GestionCompteServiceTestParametre {
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
	 * Entree des parametres
	 * @return
	 */
	@Parameters
	static public List<Object[]> getParameters() {
		Object[][] parameters = { 	{ 5000, 10000, 5000 },
									{ -5000, 10000, 5000 },
									{ 500.50, 10000.68, 5000 },
									{ -500.50, 10000, 5000.98 }	};
		return Arrays.asList(parameters);
	}

	/**
	 * Constructeur
	 * @param montant
	 * @param soldeCredit
	 * @param soldeDebit
	 */
	public GestionCompteServiceTestParametre(double montant, double soldeCredit, double soldeDebit) {
		super();
		this.montant = montant;
		this.soldeCredit = soldeCredit;
		this.soldeDebit = soldeDebit;
	}
	
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
