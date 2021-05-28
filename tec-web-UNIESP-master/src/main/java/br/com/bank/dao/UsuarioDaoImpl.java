package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.bank.model.Usuario;
import br.com.bank.util.JpaUtil;

public class UsuarioDaoImpl implements UsuarioDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		List<Usuario> lista = null;
		try {
			lista = entityManager.createQuery("from Usuario a").getResultList();
			return lista;
					
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		};
		return null;
		
	}

	@Override
	public void save(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void deletar(Long idUsuario) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Usuario client = entityManager.find(Usuario.class, idUsuario);
			entityManager.remove(client);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}		
	}

	@Override
	public Usuario findById(Long id) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			Usuario usuario = entityManager.find(Usuario.class, id);
			return usuario;
					
		} catch (NoResultException e) {
			e.getMessage();
			entityManager.close();
		};
		return null;
	}

	@Override
	public void edit(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	}
