package br.ucb.saam.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.dao.AreaDAO;

@ManagedBean
@SessionScoped
public class AtendimentoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<AreaBean>areas;
	private AreaBean area;
	
	//Constructor
	public AtendimentoMB(){
		this.areas = new AreaDAO().findAll(AreaBean.class);
		setArea(new AreaBean());
	}
	
	//Methods
	
	public String verificaAtendentes(){
		System.out.println(this.area.getNome());				
		return "/atendimento/aguarde.xhtml";
	}	
	
	
	
	// Getters and Setters
	public List<AreaBean> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}

	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	
}
