package br.ucb.saam.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.ucb.saam.beans.FuncionalidadeBean;
import br.ucb.saam.beans.UsuarioBean;

@ManagedBean
@RequestScoped
public class MenuBean {  

	private MenuModel model;  

	public MenuBean() {  
		model = new DefaultMenuModel();  

		//First submenu  
		Submenu submenu = new Submenu();  
		submenu.setLabel("Menu");

		MenuItem item = new MenuItem();
		for (FuncionalidadeBean funcionalidade : getUsuarioSessao().getPerfil().getFuncionalidades()) {
			item = new MenuItem();
			item.setValue(funcionalidade.getNomeTecnico());  
			item.setUrl(funcionalidade.getUrl());
			submenu.getChildren().add(item); 
		}

		model.addSubmenu(submenu);  

		//Second submenu  
		submenu = new Submenu();  
		submenu.setLabel("");  

		item = new MenuItem();  
		item.setValue("Sair");  
		item.setUrl("logout.xhtml");	
		item.setIcon("ui-icon ui-icon-power");
		submenu.getChildren().add(item);
		model.addSubmenu(submenu);  
		//          
		//        item = new MenuItem();  
		//        item.setValue("Dynamic Menuitem 2.2");  
		//        item.setUrl("#");  
		//        submenu.getChildren().add(item);  
		//          

	}  

	public UsuarioBean getUsuarioSessao(){
		UsuarioBean usuario = new UsuarioBean();
		usuario = (UsuarioBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return usuario;		
	}

	public MenuModel getModel() {  
		return model;  
	}     

	public void save() {  
		addMessage("Data saved");  
	}  

	public void update() {  
		addMessage("Data updated");  
	}  

	public void delete() {  
		addMessage("Data deleted");  
	}  

	public void addMessage(String summary) {  
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
		FacesContext.getCurrentInstance().addMessage(null, message);  
	}  
}  