package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="funcionalidades")
public class FuncionalidadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="COD_FUNCIONALIDADE")
	private int id;
	
	@Column(name="NOME_TECNICO")
	private String nomeTecnico;
	
	@Column(name="NOME_USUARIO")
	private String nomeUsuario;


	//Constructor---------------------------------------------------------------------------------
	public FuncionalidadeBean(){
	}

	//Getters and Setters-------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getNomeTecnico() {
		return nomeTecnico;
	}
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	
	//Subscribe---------------------------------------------------------------------------------------------







}
