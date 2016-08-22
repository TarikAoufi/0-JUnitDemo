package fr.aoufi.annuaire.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.aoufi.annuaire.dao.DAOFactory;
import fr.aoufi.annuaire.dao.NumeroDao;
import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.exception.ServiceException;
import fr.aoufi.annuaire.model.Numero;
import fr.aoufi.annuaire.model.Personne;
import fr.aoufi.annuaire.service.NumeroService;
import fr.aoufi.annuaire.service.PersonneService;
import fr.aoufi.annuaire.service.ServiceFactory;
import fr.aoufi.annuaire.util.JPAutils;

public class NumeroServiceImpl implements NumeroService {
	
	private NumeroDao numeroDAO = DAOFactory.getNumeroDao();
	private PersonneService servPersonne = ServiceFactory.getPersonneService();
	
	@Override
	public Numero create(Numero numero) throws ServiceException {
		try {
			JPAutils.beginTransaction();
			List<Personne> personnes = numero.getPersonnes();
			List<Numero> numeros = new ArrayList<>();
			
			if (!personnes.isEmpty()) {
				for (Personne personne : personnes) {
					personne.setNumeros(numeros);
					servPersonne.create(personne);
				}
			}
			JPAutils.commit();
			return numero;			
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur NumeroServiceImpl - create() "+e.getMessage(), e);
		}
	}
	
	@Override
	public void deleteById(Integer id) throws ServiceException {
		try {
			if(findById(id) != null) {
				JPAutils.beginTransaction();
				numeroDAO.delete(findById(id));
			}
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException(	"ERREUR NumeroServiceImpl - deleteById() " + e.getMessage(), e);
		}	
	}
	
	@Override
	public void delete(Numero numero) throws ServiceException {
		try {
			JPAutils.beginTransaction();
			numeroDAO.delete(numero);
			JPAutils.commit();			
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur NumeroServiceImpl - delete() "+e.getMessage(), e);
		}		
	}
	
	@Override
	public Numero update(Numero numero) throws ServiceException {
		try {
			JPAutils.beginTransaction();
			Numero num = numeroDAO.update(numero);
			JPAutils.commit();
			return num;			
		} catch (DAOException e) {
			JPAutils.rollback();
			throw new ServiceException("Erreur NumeroServiceImpl - update() "+e.getMessage(), e);
		}
	}
	
	@Override
	public Numero findById(Integer id) throws ServiceException {
		try {
			return numeroDAO.findById(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - findById() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Numero> findAll() throws ServiceException {
		try {
			return numeroDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - findAll() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Numero> find(Map<String, Object> map) throws ServiceException {
		try {
			return numeroDAO.find(map);
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - find() "+e.getMessage(), e);
		}
	}
	
	@Override
	public Numero findByTel(String tel) throws ServiceException {
		try {
			return numeroDAO.findByTel(tel);
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - findByTel() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Numero> findByType(String type) throws ServiceException {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("type", type);
			return numeroDAO.find(map);
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - findByType() "+e.getMessage(), e);
		}
	}
	
	@Override
	public List<Numero> findAllByPersonne() throws ServiceException {
		try {
			return numeroDAO.findAllByPersonne();
		} catch (DAOException e) {
			throw new ServiceException("Erreur NumeroServiceImpl - findAllByPersonne() "+e.getMessage(), e);
		}
	}
	

}
