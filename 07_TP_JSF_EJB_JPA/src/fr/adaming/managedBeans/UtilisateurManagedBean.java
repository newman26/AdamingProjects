package fr.adaming.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.model.Utilisateur;


@ManagedBean(name="userMB")
@SessionScoped
public class UtilisateurManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Utilisateur user;
	
	
	@EJB
	IUtilisateurDAO userDao;

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
		userDao.ajouterUserDao(user);
		return "accueil";
	} 
	
	
	//methode Supprimer
	
	public String supprimerUser(){
		userDao.supprimerUserDao(user.getId());
		return "accueil";
	}
	
}
