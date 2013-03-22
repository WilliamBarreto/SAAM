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

/**
 * Est� classe � modelo para um objeto do tipo Perguntas frequentes
 * 
 * @author Neslon Gustavo
 * @version 1.0
 * @since 2013
 */

@Entity
@Table(name="perguntas_frequentes")
public class PerguntaFrequenteBean  implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_pergunta_frequente")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_area")
	private AreaBean area;
	
	@Column(name="pergunta")
	private String pergunta;
	
	@Column(name="resposta")
	private String resposta;
	
	@Column(name="data_publicacao")
	private Date data;



	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AreaBean getArea() {
		return area;
	}

	public void setArea(AreaBean area) {
		this.area = area;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}	

}
