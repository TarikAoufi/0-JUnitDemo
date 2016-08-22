package fr.aoufi.annuaire.service;

import java.util.List;

import fr.aoufi.annuaire.exception.ServiceException;
import fr.aoufi.annuaire.model.Numero;

public interface NumeroService extends GenericService<Numero, Integer> {
	
	Numero findByTel(String tel) 		 throws ServiceException;
	List<Numero> findByType(String type) throws ServiceException;
	List<Numero> findAllByPersonne() 	 throws ServiceException;

}
