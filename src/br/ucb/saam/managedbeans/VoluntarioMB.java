package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.beans.VoluntarioBean;
import br.ucb.saam.dao.AreaDAO;
import br.ucb.saam.dao.VoluntarioDAO;

@ManagedBean
@SessionScoped
public class VoluntarioMB {

	private VoluntarioBean voluntario;
	private List<VoluntarioBean> voluntarios;
	private List<AreaBean> areas;
	private VoluntarioDAO voluntarioDAO;
	

// Constructor
	
	public VoluntarioMB(){
		setVoluntario(new VoluntarioBean());
		setAreas(new AreaDAO().findAll(AreaBean.class));
		setVoluntarios(new ArrayList<VoluntarioBean>());
		setVoluntarioDAO(new VoluntarioDAO());
	}
	
// Methods
	
	public String cadastrar(){
		
		voluntarioDAO.saveOrUpdate(voluntario);
		voluntario = new VoluntarioBean();
		return "sucess";
	}
	
	public String index(){
		voluntarios = voluntarioDAO.findAll(VoluntarioBean.class);
		return "voluntario/index";
	}
	
	public String show(){
		
		return "show";
	}
	
	public String reprovar(ActionEvent evento){
		this.voluntario = (VoluntarioBean) evento.getComponent().getAttributes().get("voluntario");
		voluntarioDAO.delete(voluntario);
		return index();
	}
	
	public String aprovar(){
		//To do!
		return "";
	}
	
	
// Getters and Setters
	public List<AreaBean> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}

	public VoluntarioBean getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(VoluntarioBean voluntario) {
		this.voluntario = voluntario;
	}

	public List<VoluntarioBean> getVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(List<VoluntarioBean> voluntarios) {
		this.voluntarios = voluntarios;
	}

	public VoluntarioDAO getVoluntarioDAO() {
		return voluntarioDAO;
	}

	public void setVoluntarioDAO(VoluntarioDAO voluntarioDAO) {
		this.voluntarioDAO = voluntarioDAO;
	}
	

}
