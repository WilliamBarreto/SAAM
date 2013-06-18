package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.saam.beans.LogBean;
import br.ucb.saam.dao.LogDAO;

/**
 * Está classe representa um controller para Log do Sistema 
 * @author William Barreto.
 * @since 2013
 */
@ManagedBean
@SessionScoped
public class LogMB {
	
	LogDAO logDao;
	List<LogBean> logs;
	
	Date dataInicio;
	Date dataFim;

	public LogMB() {
		this.logDao = new LogDAO();
		this.logs = new ArrayList<LogBean>();
	}
	
	public String listar(){
		this.logs = logDao.findAll(LogBean.class);
		return "/log/index";
	}
	
	public String listarIntervalo(){
	
		this.logs = logDao.buscarIntervalo(dataInicio, dataFim);
		
		return "/log/index";
	}

	public List<LogBean> getLogs() {
		return logs;
	}

	public void setLogs(List<LogBean> logs) {
		this.logs = logs;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
}
