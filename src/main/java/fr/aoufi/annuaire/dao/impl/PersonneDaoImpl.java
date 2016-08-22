package fr.aoufi.annuaire.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.aoufi.annuaire.dao.GenericDaoJpa;
import fr.aoufi.annuaire.dao.PersonneDao;
import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.model.Personne;
import fr.aoufi.annuaire.util.JPAutils;

public class PersonneDaoImpl extends GenericDaoJpa<Personne, Integer> implements PersonneDao {

	protected EntityManager em = JPAutils.getEntityManager();
	
	public PersonneDaoImpl() {
		super(Personne.class);
	}


	@Override
	public List<Personne> findByName(String nom) throws DAOException{
		try{
			TypedQuery<Personne> findIdQuerry = em.createQuery(
					"SELECT DISTINCT(p) FROM Personne p "
					+ "LEFT JOIN FETCH p.numeros "
					+ "WHERE p.nom=:nom ", 
//					+ "GROUP BY p.id",
					Personne.class);
			findIdQuerry.setParameter("nom", nom);
			return findIdQuerry.getResultList();
		}catch(PersistenceException e){
			throw new DAOException(
					"Erreur PersonneDaoImpl - findByName() "+e.getMessage(), e);
			
		}
	}
	
	@Override
	public List<Personne> findByBirth(Date naissance) throws DAOException {
		try{
			TypedQuery<Personne> findIdQuerry = em.createQuery(
					"SELECT DISTINCT p FROM Personne p "
					+ "LEFT JOIN FETCH p.numeros "
					+ "WHERE p.dateNaissance=:date ",
//					+ "GROUP BY p.id",
							Personne.class);
			findIdQuerry.setParameter("date", naissance);
			return findIdQuerry.getResultList();
		}catch(PersistenceException e){
			throw new DAOException("Erreur PersonneDaoImpl - findByBirth() "+e.getMessage(), e);
			
		}
	}
	

	@Override
	public List<Personne> findAllByNumero() throws DAOException {
		try{
			TypedQuery<Personne> tQuery = em.createQuery(
					"SELECT DISTINCT p FROM Personne p "
					+ "LEFT JOIN FETCH p.numeros ",	Personne.class);
			return tQuery.getResultList();
		}catch(PersistenceException e){
			throw new DAOException("Erreur PersonneDaoImpl - findAllByNumero() "+e.getMessage(), e);
			
		}
	}

}
