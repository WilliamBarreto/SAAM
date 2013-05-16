package br.ucb.saam.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.saam.beans.AtendimentoBean;
import br.ucb.saam.beans.AvaliacaoBean;
import br.ucb.saam.beans.ClassificacaoBean;
import br.ucb.saam.dao.AtendimentoDAO;
import br.ucb.saam.dao.AvaliacaoDAO;
import br.ucb.saam.dao.ClassificacaoDAO;
import br.ucb.saam.util.JSFMensageiro;

@ManagedBean
@SessionScoped
public class AvaliacaoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	AtendimentoBean atendimento;
	AvaliacaoBean avaliacao;
	int nota;
	int id;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	AvaliacaoDAO avaliacaoDao;
	AtendimentoDAO atendimentoDao;
	
	
	public AvaliacaoMB(){
		
		this.avaliacao = new AvaliacaoBean();
		this.avaliacaoDao = new AvaliacaoDAO();
		this.atendimento = new AtendimentoBean();
		this.atendimentoDao = new AtendimentoDAO();
	}


	public String salvar(){
		if(this.nota == 0){
			JSFMensageiro.error("Deve ser selecionada uma nota para esta avaliação");
			return "avaliacao.xhtml?id="+this.id;
		}else{
			this.avaliacao.setClassificacao(buscaClassificacao());
			this.avaliacao.setData(new Date(System.currentTimeMillis()));
			
			avaliacaoDao.saveOrUpdate(this.avaliacao);
			
			this.atendimento = (AtendimentoBean) atendimentoDao.buscarPorId(AtendimentoBean.class,this.id);
			this.atendimento.setAvaliacao(this.avaliacao);
			
			this.atendimentoDao.saveOrUpdate(this.atendimento);
			this.avaliacao = new AvaliacaoBean();
			this.atendimento = new AtendimentoBean();
			
			JSFMensageiro.info("Avaliação cadastrada com sucesso.");
			
			return "fimAtendimento";
		}
	}
	
	public AvaliacaoBean getAvaliacao() {
		return avaliacao;
	}


	public void setAvaliacao(AvaliacaoBean avaliacao) {
		this.avaliacao = avaliacao;
	}


	public ClassificacaoBean buscaClassificacao(){
		return (ClassificacaoBean) new ClassificacaoDAO().buscarPorId(ClassificacaoBean.class, this.nota);
	}
	
	public AtendimentoBean getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(AtendimentoBean atendimento) {
		this.atendimento = atendimento;
	}

	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
