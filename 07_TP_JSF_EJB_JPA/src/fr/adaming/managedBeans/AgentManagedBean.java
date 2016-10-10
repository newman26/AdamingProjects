package fr.adaming.managedBeans;

import java.io.Serializable;

import java.util.List;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.dao.IAgentDAO;
import fr.adaming.dao.IUtilisateurDAO;
import fr.adaming.model.Agent;
import fr.adaming.model.Utilisateur;


@ManagedBean(name="agentMB")
@RequestScoped
public class AgentManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mail;
	private String password;
	private Agent agent;

	private List<Utilisateur> liste;

	 HttpSession session;
	
	@EJB
	private IAgentDAO agentDao;
	@EJB
	private IUtilisateurDAO userDao;
	


	public AgentManagedBean() {
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

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public IAgentDAO getAgentDao() {
		return agentDao;
	}


	public void setAgentDao(IAgentDAO agentDao) {
		this.agentDao = agentDao;
	}
	
	

	public String isExist(){
		String email=this.mail;
		String mdp=this.password;
		List<Agent> listeAgent=agentDao.isExist(email,mdp );
		
		if (listeAgent.size()==1){
			 agent=listeAgent.get(0);
			
			 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);

			liste=userDao.getAllUtilisateursByIdAgent(agent);
			 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listeUsers", liste);
			return "succes";
		}else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd","Please enter correct username and Password"));
			return "echec";
		}
	}
	
	public String retourAccueil(){
		return "accueil";
		
	}


public String seDeconnecter(){
	 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return  "/login.xhtml?faces-redirect=true";
}

	

}
