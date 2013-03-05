package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.dao.UsuarioDAO;




@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {

	private UsuarioBean usuario;
	private UsuarioDAO usuarioDAO;
	private List<UsuarioBean> usuarios;


	public UsuarioMB(){
		setUsuario(new UsuarioBean());
		setUsuarioDAO(new UsuarioDAO());
		setUsuarios(new ArrayList<UsuarioBean>());
	}


	public String login(){

		this.usuarios = usuarioDAO.findAll(UsuarioBean.class);

		for (UsuarioBean user : usuarios) {	
			if(user.equals(this.usuario)){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
				return "home";
			}
		}	
		return "index";
	}




	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}







}
