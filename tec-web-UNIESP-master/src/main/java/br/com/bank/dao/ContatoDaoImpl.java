package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.bank.model.Contato;
import br.com.bank.util.JpaUtil;

public class ContatoDaoImpl implements ContatoDao{

	@Override
	public Contato findById(Long id) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Contato contato = entityManager.find(Contato.class, id);
			return contato;
					
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		};
		return null;		
	}
	
	@Override
	public Contato getContato(String name) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Contato contato = entityManager.createNamedQuery("Contato.getByName", Contato.class)
					.setParameter("name", name)
					.getSingleResult();
			return contato;
					
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		};
		return null;
	}
	
	@Override
	public void salvar(Contato contato) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(contato);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Override
	public void edit(Contato contato) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			entityManager.merge(contato);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contato> list() {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Contato c");
		List<Contato> contatos = query.getResultList();
		return contatos;
	}

	@Override
	public void deletar(Long idContato) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Contato contato = entityManager.find(Contato.class, idContato);
			entityManager.remove(contato);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	

}
