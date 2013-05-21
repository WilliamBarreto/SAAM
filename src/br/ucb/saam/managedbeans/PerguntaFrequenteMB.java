package br.ucb.saam.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.beans.PerguntaFrequenteBean;
import br.ucb.saam.dao.AreaDAO;
import br.ucb.saam.dao.PerguntaFrequenteDAO;
import br.ucb.saam.util.JSFMensageiro;

@ManagedBean(name="perguntaFrequenteMB")
@SessionScoped
public class PerguntaFrequenteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<PerguntaFrequenteBean> resultados;
	private PerguntaFrequenteBean perguntaFrequente;
	private List<PerguntaFrequenteBean> perguntasFrequentes;
	private PerguntaFrequenteDAO perguntaFrequenteDAO;
	private List<AreaBean> areas;
	private AreaDAO areaDAO;
	
	public PerguntaFrequenteMB(){
		setPerguntaFrequente(new PerguntaFrequenteBean());
		setPerguntaFrequenteDAO(new PerguntaFrequenteDAO());
		setPerguntasFrequentes(new ArrayList<PerguntaFrequenteBean>());
		setAreas(new ArrayList<AreaBean>());
		setAreaDAO(new AreaDAO());
		setResultados(new ArrayList<PerguntaFrequenteBean>());
	}
	
	
	public String index(){
		perguntasFrequentes = perguntaFrequenteDAO.findAll(PerguntaFrequenteBean.class);
		resultados = perguntasFrequentes;
		return "/perguntaFrequente/index";
	}
	
	public String novo(){
		this.perguntaFrequente = new PerguntaFrequenteBean();
		areas = areaDAO.findAll(AreaBean.class);		
		return "new";
	}
	
	public String criar(){
		perguntaFrequente.setData(new Date(System.currentTimeMillis()));
		perguntaFrequenteDAO.saveOrUpdate(perguntaFrequente);
		JSFMensageiro.info("A pergunta frequente foi gravada com sucesso!");
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
	
	public void delete(){
		perguntaFrequenteDAO.delete(perguntaFrequente);
		JSFMensageiro.info("A Pergunta frequente foi excluida com sucesso!");
		perguntaFrequente = new PerguntaFrequenteBean();
		perguntasFrequentes = perguntaFrequenteDAO.findAll(PerguntaFrequenteBean.class);
		resultados = perguntasFrequentes;
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
	
	public List<PerguntaFrequenteBean> getListaPerguntasFrequentes(){
		return this.perguntasFrequentes = this.perguntaFrequenteDAO.findAll(PerguntaFrequenteBean.class);
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

	public List<PerguntaFrequenteBean> getResultados() {
		return resultados;
	}

	public void setResultados(List<PerguntaFrequenteBean> resultados) {
		this.resultados = resultados;
	}
	
}
