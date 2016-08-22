package fr.aoufi.annuaire.service;

import java.util.Date;
import java.util.List;

import fr.aoufi.annuaire.exception.ServiceException;
import fr.aoufi.annuaire.model.Personne;

public interface PersonneService extends GenericService<Personne, Integer> {
	
	List<Personne> findByName(String nom) 		throws ServiceException;
	List<Personne> findByBirth(Date naissance)  throws ServiceException;
	List<Personne> findAllByPersonne() 			throws ServiceException;

}
