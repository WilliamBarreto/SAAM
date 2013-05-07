package br.ucb.saam.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.beans.PerguntaFrequenteBean;
import br.ucb.saam.dao.AreaDAO;
import br.ucb.saam.dao.PerguntaFrequenteDAO;

@ManagedBean(name="perguntaFrequenteMB")
@SessionScoped
public class PerguntaFrequenteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private PerguntaFrequenteBean perguntaFrequente;
	private List<PerguntaFrequenteBean> perguntasFrequentes;
	private PerguntaFrequenteDAO perguntaFrequenteDAO;
	private List<AreaBean> areas;
	private AreaDAO areaDAO;
	
	public PerguntaFrequenteMB(){
		setPerguntaFrequente(new PerguntaFrequenteBean());
		setPerguntaFrequenteDAO(new PerguntaFrequenteDAO());
		setPerguntasFrequentes(perguntaFrequenteDAO.findAll(PerguntaFrequenteBean.class));
		setAreas(new ArrayList<AreaBean>());
		setAreaDAO(new AreaDAO());
	}
	
	public List<PerguntaFrequenteBean> getListaPerguntasFrequentes(){
		return this.perguntasFrequentes = this.perguntaFrequenteDAO.findAll(PerguntaFrequenteBean.class);
	}
	
	public String index(){
		getListaPerguntasFrequentes();
		return "/perguntaFrequente/index";
	}
	
	public String novo(){
		this.perguntaFrequente = new PerguntaFrequenteBean();
		areas = areaDAO.findAll(AreaBean.class);		
		return "new";
	}
	
	public String criar(){
		perguntaFrequenteDAO.saveOrUpdate(perguntaFrequente);		
		perguntaFrequente = new PerguntaFrequenteBean();		
		return index();
	}
	
	public String show(){
		return "show";
	}
	
	public String edit(){
		areas = areaDAO.findAll(AreaBean.class);		
		return "new";
	}
	
	public void delete(ActionEvent evento){
		perguntaFrequente = (PerguntaFrequenteBean) evento.getComponent().getAttributes().get("perguntaFrequente");
		perguntaFrequenteDAO.delete(perguntaFrequente);
		getListaPerguntasFrequentes();
	}
	
	
	public PerguntaFrequenteDAO getPerguntaFrequenteDAO() {
		return perguntaFrequenteDAO;
	}
	public void setPerguntaFrequenteDAO(PerguntaFrequenteDAO perguntaFrequenteDAO) {
		this.perguntaFrequenteDAO = perguntaFrequenteDAO;
	}
	public List<AreaBean> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<PerguntaFrequenteBean> getPerguntasFrequentes() {
		return perguntasFrequentes;
	}
	public void setPerguntasFrequentes(List<PerguntaFrequenteBean> perguntasFrequentes) {
		this.perguntasFrequentes = perguntasFrequentes;
	}


	public PerguntaFrequenteBean getPerguntaFrequente() {
		return perguntaFrequente;
	}
	public void setPerguntaFrequente(PerguntaFrequenteBean perguntaFrequente) {
		this.perguntaFrequente = perguntaFrequente;
	}

	public AreaDAO getAreaDAO() {
		return areaDAO;
	}
	public void setAreaDAO(AreaDAO areaDAO) {
		this.areaDAO = areaDAO;
	}
	
}
