package br.com.triadworks.bugtracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Status;
import br.com.triadworks.bugtracker.modelo.Usuario;

@ManagedBean
public class BugBean {

	private Bug bug = new Bug();
	@ManagedProperty("#{bugDao}")
	private BugDao dao;
	private List<Bug> bugs = new ArrayList<Bug>();
	
	public void lista(){
		this.bugs = dao.lista();
	}
	
	public void remove(Bug bug){
		dao.remove(bug);
		this.bugs = dao.lista();
		new FacesUtils().adicionaMensagemDeSucesso("Bug removido com Sucesso!");
	}
	
	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	@PostConstruct
	public void init() {
		this.bug.setResponsavel(new Usuario());
	}

	public void adiciona() {
		dao.salva(bug);
		this.bug = new Bug();
		new FacesUtils()
				.adicionaMensagemDeSucesso("Bug adicionado com sucesso!");
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public BugDao getDao() {
		return dao;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}

	public List<Status> getTodosOsStatus() {
		return Arrays.asList(Status.values());
	}
}