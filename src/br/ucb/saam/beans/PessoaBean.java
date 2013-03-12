/**
 * 
 */
package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * Esta classe representa um modelo do objeto Pessoa
 * 
 * @author William Barreto
 * @version 1.0
 * @since 2013
 */
@MappedSuperclass
public class PessoaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private String nome;
	private String telefone;
	private String email;
	private String sexo;
	
	//Constructor
	
	public PessoaBean(){
		
	}	
	
	//Methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object object){

		PessoaBean aux = (PessoaBean) object;

		if(aux.getNome().equalsIgnoreCase(this.getNome()) && 
				aux.getEmail().equalsIgnoreCase(this.getEmail())){
			return true;
		}
		return false;
	}
	
	//Getters and Setters	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
