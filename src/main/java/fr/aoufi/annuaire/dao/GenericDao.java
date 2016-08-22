package fr.aoufi.annuaire.dao;

import java.util.List;
import java.util.Map;

import fr.aoufi.annuaire.exception.DAOException;

public interface GenericDao<T, Pk>  {
	
	T create(T entity) 				      throws DAOException;	
	void deleteById(Pk key) 			  throws DAOException;
	void delete(T entity) 				  throws DAOException;	
	T update(T entity) 					  throws DAOException;
	T findById(Pk key) 					  throws DAOException;	
	List<T> findAll() 					  throws DAOException;
	List<T> find(Map<String, Object> map) throws DAOException;

}
