package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.saam.beans.AtendimentoBean;
import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.dao.AtendimentoDAO;

@ManagedBean
@SessionScoped
public class RelatorioMB {
	
	private List<AtendimentoBean> atendimentos;
	private AtendimentoDAO atendimentoDao;
	private AtendimentoBean atendimento;
	
	public RelatorioMB(){
		atendimentos = new ArrayList<AtendimentoBean>();
		atendimentoDao = new AtendimentoDAO();
		atendimento = new AtendimentoBean();
	}
	
	
	public String historico(){
		if (getUsuarioSessao().getPerfil().getId() == 2){
				atendimentos = atendimentoDao.findAllByAtendente(getUsuarioSessao());
			return "/atendimento/historico";
		}else{
			if (getUsuarioSessao().getPerfil().getId() == 5){
					atendimentos = atendimentoDao.findAllByAtendido(getUsuarioSessao());
			return "/atendimento/historico";
			}
		}
		System.out.println("Aqui! no gerente");
		atendimentos = atendimentoDao.findAll(AtendimentoBean.class);
		return "/atendimento/historico";
	}
	
	public String show(){
		
		return "show";
	}
	
	public UsuarioBean getUsuarioSessao(){
		UsuarioBean usuario = (UsuarioBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		return usuario;		
	}
	
	public List<AtendimentoBean> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<AtendimentoBean> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public AtendimentoDAO getAtendimentoDao() {
		return atendimentoDao;
	}

	public void setAtendimentoDao(AtendimentoDAO atendimentoDao) {
		this.atendimentoDao = atendimentoDao;
	}

	public AtendimentoBean getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(AtendimentoBean atendimento) {
		this.atendimento = atendimento;
	}


}
