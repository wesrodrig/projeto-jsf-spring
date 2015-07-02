package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;



@ManagedBean
public class UsuarioBean {
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao dao;
	
	public UsuarioDao getDao() {
		return dao;
	}


	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;


	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public Usuario getUsuario() {
		return this.usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void adiciona(){
		
		dao.adiciona(this.usuario);
		this.usuario = new Usuario();
		new FacesUtils().adicionaMensagemDeSucesso("Usuário adicionado com sucesso!");
		
	}
	
	public void lista(){
		
		this.usuarios = dao.lista();
	}
	
	public void remove(Usuario usuario){
		
		dao.remove(usuario);
		this.usuarios = dao.lista();
		new FacesUtils().adicionaMensagemDeSucesso("Usuário Removido com sucesso!");

	}
	
	public void altera(){
		
		dao.atualiza(this.usuario);
		new FacesUtils().adicionaMensagemDeSucesso("Usuário alterado com sucesso!");
	
	}
}


	