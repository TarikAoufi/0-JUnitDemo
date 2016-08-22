package fr.aoufi.annuaire.service;

import java.util.List;
import java.util.Map;

import fr.aoufi.annuaire.exception.ServiceException;

public interface GenericService<T, Pk> {
	
	T create(T entity) 				      throws ServiceException;	
	void deleteById(Pk key) 			  throws ServiceException;
	void delete(T entity) 				  throws ServiceException;	
	T update(T entity) 					  throws ServiceException;
	T findById(Pk key) 					  throws ServiceException;	
	List<T> findAll() 					  throws ServiceException;
	List<T> find(Map<String, Object> map) throws ServiceException;

}
