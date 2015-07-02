package br.com.triadworks.bugtracker.service;

import br.com.triadworks.bugtracker.modelo.Usuario;

public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}