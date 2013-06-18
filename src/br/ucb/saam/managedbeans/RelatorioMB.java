package br.ucb.saam.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.beans.AtendimentoBean;
import br.ucb.saam.beans.MensagemBean;
import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.dao.AtendimentoDAO;
import br.ucb.saam.dao.MensagemDAO;

@ManagedBean
@SessionScoped
public class RelatorioMB {
	
	private List<AtendimentoBean> atendimentos;
	private AtendimentoDAO atendimentoDao;
	private AtendimentoBean atendimento;
	private MensagemBean mensagem;
	private MensagemDAO mensagemDao;
	
	public RelatorioMB(){
		atendimentos = new ArrayList<AtendimentoBean>();
		atendimentoDao = new AtendimentoDAO();
		atendimento = new AtendimentoBean();
		mensagemDao = new MensagemDAO();
		setMensagem(new MensagemBean());
	}
	
	
	public String atender(){
		atendimentos = atendimentoDao.buscarNaoAtendido(getUsuarioSessao(),getAreaSessao());
		return "/atendimento/listaNaoAtendidos.xhtml";
	}
	
	public String responder(){
		return "/atendimento/visualizaMensagem";
	}
	
	public String salvarResposta(){
		
		this.mensagem.setData(new Date(System.currentTimeMillis()));
		this.mensagem.setUsuario(getUsuarioSessao());
		
		atendimento = (AtendimentoBean) atendimentoDao.buscarPorId(AtendimentoBean.class, atendimento.getId());
		
		this.atendimento.getMensagens().add(mensagem);		
		this.atendimento.setDataFim(new Date(System.currentTimeMillis()));
		this.atendimento.setAtendente(getUsuarioSessao());
		
		
		mensagemDao.saveOrUpdate(mensagem);
		atendimentoDao.saveOrUpdate(atendimento);
		
		
		this.atendimento = new AtendimentoBean();
		this.mensagem = new MensagemBean(); 
		atendimentos = atendimentoDao.buscarNaoAtendido(getUsuarioSessao(),getAreaSessao());
		return "/atendimento/listaNaoAtendidos.xhtml";
		
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
	
	public AreaBean getAreaSessao(){
		AreaBean area = (AreaBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("area");
		return area;
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


	public MensagemBean getMensagem() {
		return mensagem;
	}


	public void setMensagem(MensagemBean mensagem) {
		this.mensagem = mensagem;
	}


}
