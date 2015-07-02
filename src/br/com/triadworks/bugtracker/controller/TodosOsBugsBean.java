package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;

@ViewScoped
@ManagedBean
public class TodosOsBugsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Bug> bugs;
	@ManagedProperty("#{bugDao}")
	private BugDao dao;

	@PostConstruct
	public void init() {
		this.bugs = dao.lista();
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}
}