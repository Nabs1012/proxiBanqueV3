package fr.gtm.presentation;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Compte;
import fr.gtm.service.ClientService;
import fr.gtm.service.GestionCompteService;

@ManagedBean(name="clientBean")
@SessionScoped
public class ClientBean {
	private Client client = new Client();
	List<Compte> lc = new ArrayList<Compte>();
	private Compte compte;
	private Compte compteCredit;
	private Compte compteDebit;
	private double montant;
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public ClientBean() {
		super();
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	} 
	

	// Methode métier associer au client
	
	public String update() {
		// instanciation du client servant a sauvegarder no modification
		Client cUpdate ;
		//Instanciation de la couche service client contenant la methode updateClient
		ClientService clientservice = new ClientService();
		cUpdate= clientservice.updateClient(this.client);
		if(cUpdate != null) {
			return "resultatOK";
		}else {
			 return "resultatKO";
		}
	}
	public String listeCompte() {
		GestionCompteService compteservice = new GestionCompteService();
	 lc = compteservice.getAllCompte( );
	if(lc !=null) {
		return"listecompte";
	}else {
		return"resultatKO";
	}
	}	
	public List<Compte> lcs(){
		GestionCompteService compteservice = new GestionCompteService();

		List<Compte>listeCp=compteservice.getAllCompte();
		return listeCp;
	}
	
	public Object virement() {
		GestionCompteService compteservice = new GestionCompteService();
		ClientService clientservice = new ClientService();
		boolean reponse=false;
		compteCredit=compteservice.credit(compteDebit, this.montant);
		compteDebit=compteservice.debit(compteCredit, this.montant);
		reponse=compteservice.virementCompteACompte(compteCredit, compteDebit, montant);
		if (reponse) {
			return "resultatOK";
		}else {
			return "resultatKO";
		}
	
}
	public Compte getCompteCredit() {
		return compteCredit;
	}
	public void setCompteCredit(Compte compteCredit) {
		this.compteCredit = compteCredit;
	}
	public Compte getCompteDebit() {
		return compteDebit;
	}
	public void setCompteDebit(Compte compteDebit) {
		this.compteDebit = compteDebit;
	}
}

