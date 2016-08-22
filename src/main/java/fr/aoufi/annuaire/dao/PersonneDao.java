package fr.aoufi.annuaire.dao;

import java.util.Date;
import java.util.List;

import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.model.Personne;


public interface PersonneDao extends GenericDao<Personne, Integer>{
	
	List<Personne> findByName(String nom) 		   throws DAOException;
	List<Personne> findByBirth(Date naissance) 	   throws DAOException;
	List<Personne> findAllByNumero()               throws DAOException;
	
}
