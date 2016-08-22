package fr.aoufi.annuaire.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.aoufi.annuaire.dao.DAOFactory;
import fr.aoufi.annuaire.dao.NumeroDao;
import fr.aoufi.annuaire.dao.PersonneDao;
import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.exception.ServiceException;
import fr.aoufi.annuaire.model.Numero;
import fr.aoufi.annuaire.model.Personne;
import fr.aoufi.annuaire.service.PersonneService;
import fr.aoufi.annuaire.util.JPAutils;

public class PersonneServiceImpl implements PersonneService {
	
	private PersonneDao personneDao = DAOFactory.getPersonneDao();
	private NumeroDao   numeroDao   = DAOFactory.getNumeroDao();
	
	@Override
	public Personne create(Personne personne) throws ServiceException {
		try{
			JPAutils.beginTransaction();
			List<Numero> numeros = personne.getNumeros();
			List<Personne> personnes = new ArrayList<>();
			personnes.add(personne);
			if (!numeros.isEmpty()) {
				for (Numero numero : numeros) {
					numero.setPersonnes(personnes);
					numero = numeroDao.create(numero);
				}
			}
			Personne pers = personneDao.create(personne);
			JPAutils.commit();
			return pers;			
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur PersonneServiceImpl - create() "+e.getMessage(), e);
		}
	}
	
	@Override
	public void deleteById(Integer id) throws ServiceException {
		try {
			if(findById(id) != null) {
				JPAutils.beginTransaction();
				personneDao.delete(findById(id));
			}
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException(	"ERREUR PersonneServiceImpl - deleteById() " + e.getMessage(), e);
		}			
	}
	
	@Override
	public void delete(Personne personne) throws ServiceException {
		try {
			JPAutils.beginTransaction();
			personneDao.delete(personne);
			JPAutils.commit();		
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur PersonneServiceImpl - delete() "+e.getMessage(), e);
		}		
	}
	
	@Override
	public Personne update(Personne personne) throws ServiceException {
		try {
			JPAutils.beginTransaction();
			Personne pers = personneDao.update(personne);
			JPAutils.commit();
			return pers;			
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur PersonneServiceImpl - update() "+e.getMessage(), e);
		}
	}
	
	@Override
	public Personne findById(Integer id) throws ServiceException {
		try {
			return personneDao.findById(id);			
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - findById() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Personne> findAll() throws ServiceException {
		try {
			return personneDao.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - findAll() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Personne> find(Map<String, Object> map) throws ServiceException {
		try {
			return personneDao.find(map);			
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - find() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Personne> findByName(String nom) throws ServiceException {
		try {
			return personneDao.findByName(nom);			
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - findByName() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Personne> findByBirth(Date dateN) throws ServiceException {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("dateNaissance", dateN);			
			return personneDao.findByBirth(dateN);				
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - findByBirth() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Personne> findAllByPersonne() throws ServiceException {
		try {
			return personneDao.findAllByNumero();
		} catch (DAOException e) {
			throw new ServiceException("Erreur PersonneServiceImpl - findAllByPersonne() "+e.getMessage(), e);
		}
	}
	
	public PersonneDao getPersonneDao() {
		return personneDao;
	}
	
	public void setPersonneDao(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}
	
	public NumeroDao getNumeroDao() {
		return numeroDao;
	}
	
	public void setNumeroDao(NumeroDao numeroDao) {
		this.numeroDao = numeroDao;
	}
	
	

}
