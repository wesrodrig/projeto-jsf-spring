package br.com.triadworks.bugtracker.controller.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.triadworks.bugtracker.controller.UsuarioWeb;

public class AutorizacaoListener implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();

		String paginaAcessada = context.getViewRoot().getViewId();
		if ("/login.xhtml".equals(paginaAcessada)) {
			return;
		}
		UsuarioWeb usuarioWeb = context.getApplication().evaluateExpressionGet(
				context, "#{usuarioWeb}", UsuarioWeb.class);
		
		if(!usuarioWeb.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/login?faces-redirect=true");
			context.renderResponse();	
		}
	
	}

	public void beforePhase(PhaseEvent event) {

	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
