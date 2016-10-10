package fr.adaming.dao;

import javax.ejb.Local;

@Local
public interface IAgentDAO {
	 public int isExist(String mail, String mdp);

}
