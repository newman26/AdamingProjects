package fr.adaming.dao;




import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;


@Stateless

public class AgentDAO implements IAgentDAO{

	@PersistenceContext(unitName="PU")
	EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> isExist(String mail, String mdp) {
		System.out.println("--------------------------je suis dans la couche dao\n");
String req=" FROM Agent a"
               + " WHERE a.mail=:pmail";
		Query query=em.createQuery(req);
		query.setParameter("pmail", mail);
		List<Agent> liste=query.getResultList();
		
for (Agent a:liste){
		System.out.println(a);
}
		if (liste.size()==1){
			System.out.println("______________________________ on a trouvé un utilisateur____________________");
			return liste;
			
		}else{
			System.out.println("\n______________________________ on n'a pas trouvé un utilisateur____________________");
			return null;
		}
	}
	
	
}
