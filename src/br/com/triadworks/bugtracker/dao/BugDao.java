package br.com.triadworks.bugtracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Comentario;

@Transactional
@Repository
public class BugDao {
	@PersistenceContext
	private EntityManager manager;

	public List<Bug> lista() {
		return manager.createQuery("select b from Bug b", Bug.class)
				.getResultList();
	}

	public void salva(Bug bug) {

		manager.persist(bug);
	}

	public void atualiza(Bug bug) {
		manager.merge(bug);

	}

	public void remove(Bug bug) {
		manager.remove(manager.merge(bug));

	}

	public Bug busca(Integer id) {
		return manager.find(Bug.class, id);

	}

	public List<Bug> listaPaginada(int inicio, int quantidade) {
		return manager.createQuery("select b from Bug b", Bug.class)
				.setFirstResult(inicio).setMaxResults(quantidade)
				.getResultList();

	}

	public int contaTodos() {
		Long count = manager.createQuery("select count(b) from Bug b",
				Long.class).getSingleResult();
		return count.intValue();
	}

	public List<Bug> getBugsDoUsuario(Integer id) {
		return manager
				.createQuery(
						"select b from Bug b where b.responsavel.id = :id",
						Bug.class).setParameter("id", id).getResultList();

	}

	public Bug buscaComComentarios(Integer id) {
		Bug bug = manager.find(Bug.class, id);
		if (bug != null)
			bug.getComentarios().size();
		return bug;

	}

	public void comenta(Integer id, Comentario comentario) {
		Bug bug = this.busca(id);
		bug.comenta(comentario);

	}

	public void fecha(Integer id, Comentario comentario) {
		Bug bug = this.busca(id);
		bug.fecha(comentario);

	}

}
