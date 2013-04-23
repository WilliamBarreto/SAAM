package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe para objetos do tipo Classificacao, onde serão contidos, valores e métodos para o mesmo.
 *  Representa as classificações utilizadas pela aplicação. Ex: Ótimo, Bom e etc.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="classificacoes")
public class ClassificacaoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="COD_CLASSIFICACAO")	
	private int id;
	
	@Column(name="NOME")
	private String nome;

	//Constructor
	public ClassificacaoBean(){
		
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
