package br.ucb.saam.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class AvaliacaoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="COD_AVALIACAO")
	private int id;
	
	@Column(name="SUGESTAO")
	private String sugestao;
	
	@Column(name="DATA")
	private Date data;
	
	@ManyToOne()
	@JoinColumn(name="COD_CLASSIFICACAO")
	private ClassificacaoBean classificacao;

	//Constructor
	public AvaliacaoBean(){
		
	}
	//Methods
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public ClassificacaoBean getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(ClassificacaoBean classificacao) {
		this.classificacao = classificacao;
	}
	
	
	
	
}
