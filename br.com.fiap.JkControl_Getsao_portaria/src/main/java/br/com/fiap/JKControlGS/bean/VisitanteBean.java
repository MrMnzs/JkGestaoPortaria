package br.com.fiap.JKControlGS.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.JKControlGS.dao.VisitanteDao;
import br.com.fiap.JKControlGS.model.Visitante;
import br.com.fiap.JKControlGS.service.UploadService;

@Named
@RequestScoped
public class VisitanteBean {
	
	private Visitante visitante = new Visitante();
	
	@Inject
	private VisitanteDao dao;
	private UploadedFile image;
	
	public String save() {
		System.out.println(visitante.toString());

		String path = UploadService.write(image, "setups");
		visitante.setImagePath(path);
		
		dao.create(visitante);
		
		showMessage("Visitante cadastrado com sucesso");
		
		return "visitantes?faces-redirect=true";
		
	}
	
	public String remove(Visitante visitante) {
		dao.delete(visitante);
		showMessage("Visitante apagado com sucesso");
		return "visitantes?faces-redirect=true";
	}
	
	
	public void edit() {
		dao.update(visitante);
		showMessage("Visitante atualizado com sucesso");
	}
	
	public List<Visitante> list() {
		return dao.listAll();
	}
			
	private void showMessage(String msg) {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesMessage facesMessage = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public Visitante getvisitante() {
		return visitante;
	}

	public void setvisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
	
}
