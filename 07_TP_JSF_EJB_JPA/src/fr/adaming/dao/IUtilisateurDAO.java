/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.adaming.dao;

import fr.adaming.model.Agent;
import fr.adaming.model.Utilisateur;
import java.util.List;

/**
 * @author INTI0261
 */
public interface IUtilisateurDAO {

    public List<Utilisateur> getAllUtilisateurs();
    
    public Utilisateur getUserByIdDao(int id_u);
    
    public void ajouterUserDao(Utilisateur u);
    
    public void modifierUserDao(Utilisateur u);
    
    public void supprimerUserDao(int id_u);
    
    public List<Utilisateur> getAllUtilisateursByIdAgent(Agent a);
}
