package fr.aoufi.annuaire.dao;


import java.util.List;

import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.model.Numero;


public interface NumeroDao extends GenericDao<Numero, Integer>{
	
	Numero findByTel(String tel) 				throws DAOException;
	List<Numero> findByType (String type) 		throws DAOException;	
	List<Numero> findAllByPersonne () 			throws DAOException;
	
}
