package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.dao.UsuarioDAO;
import br.ucb.saam.util.JSFMensageiro;




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


	//Methods
	public  List<UsuarioBean> getListUsuarios(){

		return this.usuarios = this.usuarioDAO.findAll(UsuarioBean.class);
	}



	public String login(){

		getListUsuarios();

		for (UsuarioBean user : usuarios) {	
			if(user.equals(this.usuario)){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
				return "home";
			}
		}
		JSFMensageiro.info("Usuário ou senha incorreta(Resumida).","Detalhada");
		return "index";
	}
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
		return "index";
	}



	public String deletar(UsuarioBean usuario){
		this.usuarios.remove(usuario);
		return null;
	}


	public String salvar(){
		System.out.println("UAUUUUUUUUUUUUUUUUUUUUU");
	
		return "";
	}

	
	
	
	/*Neste método é necessário uma nova instância do usuário
	 *Para que o valor acessado pelo método getUsuário esteja null
	 */
	public String incluir(){
		this.usuario = new UsuarioBean();
		return "formUsuario";
	}




	//getters and setters
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
