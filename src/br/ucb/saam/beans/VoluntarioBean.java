package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** Classe para objetos do tipo Voluntário, onde serão contidos, valores e métodos para o mesmo.
 *  Representa os Voluntários(Atendentes) da aplicação.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="voluntarios")
public class VoluntarioBean extends PessoaBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_voluntario")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_area")
	private AreaBean area;

	
	//Constructor
	
	public VoluntarioBean(){
		setArea(new AreaBean());
	}	
	//Methods
	

	//Getters and Setters
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
	

	

}
