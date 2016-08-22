package fr.aoufi.annuaire.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.aoufi.annuaire.exception.DAOException;
import fr.aoufi.annuaire.util.JPAutils;

public class GenericDaoJpa<T, k> implements GenericDao<T, k> {
	
	protected EntityManager em = JPAutils.getEntityManager();
	
	public  Class<T> type;
	
	public GenericDaoJpa (Class<T> type){
		 this.type=type;
	} 

	@Override
	public T create(T entity) throws DAOException {
		try {
			em.persist(entity);
			return entity;
		} catch (PersistenceException e) {
			throw new DAOException("ERREUR GenericDaoJpa - create()" + e.getMessage(), e);
		}
	}

	@Override
	public void deleteById(k key) throws DAOException {
		try {
			if(findById(key) != null)
				em.remove(findById(key));
		} catch (PersistenceException e) {
			throw new DAOException(	"ERREUR GenericDaoJpa - deleteById() " + e.getMessage(), e);
		}		
	}

	@Override
	public void delete(T entity) throws DAOException {
		try {
			em.remove(entity);
		} catch (PersistenceException e) {
			throw new DAOException(	"ERREUR GenericDaoJpa - delete() " + e.getMessage(), e);
		}
	}

	@Override
	public T update(T entity) throws DAOException {
		try {
			em.merge(entity);
			return entity;
		} catch (PersistenceException e) {
			throw new DAOException("ERREUR GenericDaoJpa - update() " + e.getMessage(), e);
		}
	}
	
	@Override
	public T findById(k key) throws DAOException {
		try {
			TypedQuery<T> query = em.createQuery("SELECT e FROM "+type.getSimpleName()+" WHERE e.id=:key",type);
			query.setParameter("key", key);
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("ERREUR GenericDaoJpa - findById() " + e.getMessage(), e);
		}
	}
	
	@Override
	public List<T> findAll() throws DAOException {
		TypedQuery<T> query = null;
		try {
			query = em.createQuery("SELECT e FROM "+type.getSimpleName()+" e ", type);
			return query.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("ERREUR GenericDaoJpa - findAll() " + e.getMessage(), e);
		}
	}

	@Override
	public List<T> find(Map<String, Object> map) throws DAOException {
		try {			
			String query;
			TypedQuery<T> tquery;
			query = new String("SELECT o FROM "+ type.getSimpleName()+ " o ");			
			if (map != null && map.size()>0) {
				query += " WHERE ";
				Set<String> key = map.keySet();
				for (String string : key) {
					query += "o." + string + "=:" + string + " AND ";
				}
				query = query.substring(0, query.lastIndexOf("AND "));
				
				tquery = em.createQuery(query, type);
				for (String string : key) {
					tquery.setParameter(string, map.get(string));
				}
			}else {
				tquery = em.createQuery(query, type);
			}
			return tquery.getResultList();
			
		} catch (PersistenceException|NullPointerException e) {
			throw new DAOException("ERREUR GenericDaoJpa - find() " + e.getMessage(), e);
		}	
	}

}
