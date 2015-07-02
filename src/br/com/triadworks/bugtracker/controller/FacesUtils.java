package br.com.triadworks.bugtracker.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {
	private FacesContext facesContext;

	public FacesUtils() {
		this.facesContext = FacesContext.getCurrentInstance();

	}

	public void adicionaMensagemDeErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);

	}

	public void adicionaMensagemDeSucesso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		facesContext.addMessage(null, facesMessage);

	}
}
