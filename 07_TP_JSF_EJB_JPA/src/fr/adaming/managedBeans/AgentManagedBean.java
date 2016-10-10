package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import fr.adaming.dao.IAgentDAO;
import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.model.Utilisateur;


@ManagedBean(name="agentMB")
@ViewScoped
public class AgentManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mail;
	private String password;
	
	private List<Utilisateur> liste;


	
	@EJB
	private IAgentDAO agentDao;
	@EJB
	private IUtilisateurDAO userDao;
	


	public AgentManagedBean() {
		
	}

	@PostConstruct
	private void init() {
		liste=userDao.getAllUtilisateurs();
	}
	
	
	public List<Utilisateur> getListe() {
		return liste;
	}

	public void setListe(List<Utilisateur> liste) {
		this.liste = liste;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public String isExist(){
		String email=this.mail;
		String mdp=this.password;
		int verif=agentDao.isExist(email,mdp );
		
		if (verif==1){
			return "succes";
		}else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd","Please enter correct username and Password"));
			return "echec";
		}
	}
	
	public String retourAccueil(){
		return "accueil";
		
	}




	public IAgentDAO getAgentDao() {
		return agentDao;
	}


	public void setAgentDao(IAgentDAO agentDao) {
		this.agentDao = agentDao;
	}
	
	
	

}
