/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.model.Agent;
import fr.adaming.model.Utilisateur;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author INTI0261
 */
@Stateless
@Local(fr.adaming.dao.IUtilisateurDAO.class)
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class UtilisateurDAO implements IUtilisateurDAO {

	@PersistenceContext(unitName="PU")
	private EntityManager em;
	
	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		String req = "select c from Utilisateur c";
	
			Query query = em.createQuery(req);

			List<Utilisateur> liste = query.getResultList();

			for (Utilisateur u : liste) {
				System.out.println(u);
			}
			return liste;
		

	}

	@Override
	public Utilisateur getUserByIdDao(int id_u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterUserDao(Utilisateur u) {

		System.out.println(u);
		em.merge(u);

		
	}

	@Override
	public void modifierUserDao(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUserDao(int id_u) {
		Utilisateur u=em.find(Utilisateur.class, id_u);
		
		em.remove(u);
	
	}

	@Override
	public List<Utilisateur> getAllUtilisateursByIdAgent(Agent a) {
		String req = "select * from utilisateurs c where c.agent_id=:id_a";

				Query query = em.createNativeQuery(req,Utilisateur.class);
		query.setParameter("id_a", a.getId());

				List<Utilisateur> liste = query.getResultList();

		return liste;
	}


	
}
