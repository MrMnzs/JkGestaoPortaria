package br.com.fiap.JKControlGS.auth;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fiap.JKControlGS.model.Visitante;

public class AuthenticationListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent e) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		String viewId = context.getViewRoot().getViewId();
		if (viewId.equals("/login.xhtml")) return;

		Visitante visitante = (Visitante) context
			.getExternalContext()
			.getSessionMap()
			.get("visitante");
		
		if(visitante != null) return;
		
		context
			.getApplication()
			.getNavigationHandler()
			.handleNavigation(context, null, "login");
	}

	@Override
	public void beforePhase(PhaseEvent e) {
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
