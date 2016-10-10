package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;

@Local
public interface IAgentDAO {
	 public List<Agent> isExist(String mail, String mdp);

}
