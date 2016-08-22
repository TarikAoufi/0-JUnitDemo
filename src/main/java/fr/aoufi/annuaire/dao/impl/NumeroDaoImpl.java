package fr.aoufi.annuaire.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.aoufi.annuaire.dao.GenericDaoJpa;
import fr.aoufi.annuaire.dao.NumeroDao;
import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.model.Numero;
import fr.aoufi.annuaire.util.JPAutils;

public class NumeroDaoImpl extends GenericDaoJpa<Numero, Integer> implements NumeroDao {
	
	protected EntityManager em = JPAutils.getEntityManager();

	
	public NumeroDaoImpl() {
		super(Numero.class);
	}

	@Override
	public Numero findByTel(String tel) throws DAOException{
		try{
			TypedQuery<Numero> tQuery = em.createQuery(
					"SELECT DISTINCT n FROM Numero n "
					+ "JOIN FETCH n.personnes "
					+ "WHERE n.tel=:tel ", Numero.class);
			tQuery.setParameter("tel", tel);
			return tQuery.getSingleResult();
		}catch(PersistenceException e){
			throw new DAOException("Erreur NumeroDaoImpl - findByTel() "+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findByType(String type) throws DAOException{
		try{
			TypedQuery<Numero> tQuery = em.createQuery(
					"SELECT DISTINCT n FROM Numero n "
					+ "JOIN FETCH n.personnes "
					+ "WHERE n.type=:type "
					+ "GROUP BY n.id ", Numero.class);
			tQuery.setParameter("type", type);
			return tQuery.getResultList();
		}catch(PersistenceException e){
			throw new DAOException("Erreur NumeroDaoImpl - findByType() "+e.getMessage(), e);
		}
	}

	@Override
	public List<Numero> findAllByPersonne() throws DAOException {
		try{
			TypedQuery<Numero> tQuery = em.createQuery(
					"SELECT DISTINCT n FROM Numero n "
					+ "LEFT JOIN FETCH n.personnes ", Numero.class);
			return tQuery.getResultList();
		}catch(PersistenceException e){
			throw new DAOException("Erreur NumeroDaoImpl - findAllByPersonne() "+e.getMessage(), e);			
		}
	}

}
