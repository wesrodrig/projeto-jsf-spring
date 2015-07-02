package br.com.triadworks.bugtracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.JPAUtil;

@Transactional
@Repository
public class UsuarioDao {
	@PersistenceContext
	private EntityManager manager;

	public List<Usuario> lista() {
			return manager.createQuery("select u from Usuario u", Usuario.class)
					.getResultList();	
			}	

	public void adiciona(Usuario usuario) {
	manager.persist(usuario);
	}

	public void atualiza(Usuario usuario) {
		manager.merge(usuario);
	}

	public void remove(Usuario usuario) {
		manager.remove(manager.merge(usuario));
	}

	public Usuario busca(Integer id) {
		return manager.find(Usuario.class, id);
	}

	public Usuario buscaPor(String login, String senha) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			return manager
					.createQuery(
							"select u from Usuario u "
									+ "where u.login = :login and u.senha = :senha", Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			manager.close();
		}
	}

}
