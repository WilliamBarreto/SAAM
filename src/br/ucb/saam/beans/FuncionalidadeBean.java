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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((nomeTecnico == null) ? 0 : nomeTecnico.hashCode());
		result = prime * result
				+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	@Override
<<<<<<< HEAD
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((nomeTecnico == null) ? 0 : nomeTecnico.hashCode());
		result = prime * result
				+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}

	@Override
=======
>>>>>>> 4fc863fe60b61c20c0c87a492189024ed2273122
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionalidadeBean other = (FuncionalidadeBean) obj;
		if (id != other.id)
			return false;
		if (nomeTecnico == null) {
			if (other.nomeTecnico != null)
				return false;
		} else if (!nomeTecnico.equals(other.nomeTecnico))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		return true;
	}






}
