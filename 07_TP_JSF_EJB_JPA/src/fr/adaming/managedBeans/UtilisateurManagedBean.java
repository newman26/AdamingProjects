package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.model.Agent;
import fr.adaming.model.Utilisateur;


@ManagedBean(name="userMB")
@RequestScoped
public class UtilisateurManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur user;
	private Agent agent;
	HttpSession session;
	
	@EJB
	IUtilisateurDAO userDao;

	@PostConstruct
	private void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		session = (HttpSession) facesContext.getExternalContext().getSession(false);
		
		agent=(Agent) session.getAttribute("agent");
	}
	public UtilisateurManagedBean() {
		this.user=new Utilisateur();
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}


	
	//Methodes Ajouter
	
	public String ajouterUser(){
		user.setAgent(agent);
		userDao.ajouterUserDao(user);
		List<Utilisateur> listeUsers=new ArrayList<Utilisateur>();
		
		listeUsers=userDao.getAllUtilisateursByIdAgent(agent);
		session.setAttribute("listeUsers", listeUsers);
		return "accueil";
	} 
	
	
	//methode Supprimer
	
	public String supprimerUser(){
		userDao.supprimerUserDao(user.getId());
List<Utilisateur> listeUsers=new ArrayList<Utilisateur>();
		
		listeUsers=userDao.getAllUtilisateursByIdAgent(agent);
		session.setAttribute("listeUsers", listeUsers);
		return "accueil";
	}
	
}
