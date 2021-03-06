package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe para objetos do tipo Tipo de Logs, onde ser�o contidos, valores e m�todos para o mesmo.
 *  Representa os tipos de log registrados na aplica��o.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="tipo_logs")
public class TipoLogBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="COD_TIPO_LOG")	
	private int id;
	
	@Column(name="NOME")
	private String nome;
	
	//Constructor	
	public TipoLogBean(){
	}

	
	//Methods
	
	//Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
