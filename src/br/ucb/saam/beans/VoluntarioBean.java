package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/** Classe para objetos do tipo Volunt�rio, onde ser�o contidos, valores e m�todos para o mesmo.
 *  Representa os Volunt�rios(Atendentes) da aplica��o.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="voluntarios")
@PrimaryKeyJoinColumn(name="COD_VOLUNTARIO")
public class VoluntarioBean extends PessoaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="SITUACAO")
	private Boolean situacao;
	
	@ManyToOne
	@JoinColumn(name="COD_AREA")
	private AreaBean area;

	
	//Constructor
	
	public VoluntarioBean(){
		setArea(new AreaBean());
	}	
	//Methods
	

	//Getters and Setters	
	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}


	public Boolean getSituacao() {
		return situacao;
	}


	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	

	

}
