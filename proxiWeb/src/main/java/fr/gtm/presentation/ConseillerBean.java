package fr.gtm.presentation;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import fr.gtm.domaine.Login;
import fr.gtm.service.ClientService;
import fr.gtm.service.LoginService;
@ManagedBean(name="conseillerBean")
@SessionScoped
public class ConseillerBean {
private Conseiller consLog = new Conseiller();
private Login log = new Login();
private Client client = new Client();

/**
 * Constructeur vide
 */
public ConseillerBean() {
	super();
}

public Conseiller getConsLog() {
	return consLog;
}

public void setConsLog(Conseiller consLog) {
	this.consLog = consLog;
}

public Login getLog() {
	return log;
}

public void setLog(Login log) {
	this.log = log;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

// Methodes metiers lies au bean 

public Object authentification() {
	// instanciation de la couche service lie au login
	LoginService loginservice = new LoginService();
	consLog=loginservice.verifLogin(log);
	if(consLog!=null) {
		return "listeClient";
	}else {
		return "mainError";
	}
}
public List<Client> lesClients() {
	//Instanciation de la couche service du client 
	//Instanciation d'une liste contenant les client du conseiller
	ClientService clientservice =new ClientService();
	List<Client> listeClient =clientservice.getAllClientConseiller(this.consLog);
     return listeClient;
}
}
