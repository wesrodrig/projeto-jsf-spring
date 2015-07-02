package br.com.triadworks.bugtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;

@Service("autenticador")
public class AutenticadorImpl implements Autenticador {
private UsuarioDao dao;

@Autowired
public AutenticadorImpl(UsuarioDao dao){
	this.dao = dao;
}
	
	@Override
	public Usuario autentica(String login, String senha) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscaPor(login, senha);
		return usuario;
	}

}