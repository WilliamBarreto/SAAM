package br.ucb.saam.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.ucb.saam.beans.FuncionalidadeBean;
import br.ucb.saam.beans.PerfilBean;
import br.ucb.saam.dao.FuncionalidadeDAO;
import br.ucb.saam.dao.PerfilDAO;

@ManagedBean(name="perfilMB")
@SessionScoped
public class PerfilMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String resultado;
	private PerfilBean perfil;
	private PerfilDAO perfilDAO;
	private List<PerfilBean> perfis;
	private List<FuncionalidadeBean> funcionalidades;
	private FuncionalidadeDAO funcionalidadeDAO;
	
	public PerfilMB(){
		setPerfil(new PerfilBean());
		setPerdilDAO(new PerfilDAO());
		setPerfis(perfilDAO.findAll(PerfilBean.class));
		setFuncionalidades(new ArrayList<FuncionalidadeBean>());
		setFuncionalidadeDAO(new FuncionalidadeDAO());
	}
	
	public String index(){
		this.perfis = perfilDAO.findAll(PerfilBean.class);		
		return "/perfil/index";
	}
	
	public String show() {		
		funcionalidades = (List<FuncionalidadeBean>) perfil.getFuncionalidades();
		return "show";
	}
	
	public String novo(){
		this.perfil = new PerfilBean();
		funcionalidades = funcionalidadeDAO.findAll(FuncionalidadeBean.class);
		
		return "new";
	}
	
	public String criar(){
		perfilDAO.saveOrUpdate(perfil);
		return index();
	}
	
	public String edit(){
		
		funcionalidades = funcionalidadeDAO.findAll(FuncionalidadeBean.class);
		return "new";
	}
	
	public void delete(ActionEvent evento){
		
		this.perfil = (PerfilBean) evento.getComponent().getAttributes().get("perfil");
		perfilDAO.delete(perfil);
		this.perfis = perfilDAO.findAll(PerfilBean.class);
	}
	
	public String buscaPorNome(){
		
		this.perfis = (List<PerfilBean>) perfilDAO.buscarPorNome(PerfilBean.class, resultado);
		return "/perfil/index";
	}
	
	
	public PerfilBean getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}
	public PerfilDAO getPerdilDAO() {
		return perfilDAO;
	}
	public void setPerdilDAO(PerfilDAO perdilDAO) {
		this.perfilDAO = perdilDAO;
	}
	public List<FuncionalidadeBean> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(List<FuncionalidadeBean> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	public FuncionalidadeDAO getFuncionalidadeDAO() {
		return funcionalidadeDAO;
	}
	public void setFuncionalidadeDAO(FuncionalidadeDAO funcionalidadeDAO) {
		this.funcionalidadeDAO = funcionalidadeDAO;
	}

	public List<PerfilBean> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilBean> perfis) {
		this.perfis = perfis;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
