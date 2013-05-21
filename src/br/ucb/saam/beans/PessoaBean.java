/**
 * 
 */
package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/** Classe para objetos do tipo Pessoa, onde ser�o contidos, valores e m�todos para o mesmo.
 *  Representa uma Pessoa na aplica��o.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="pessoas")
@Inheritance(strategy=InheritanceType.JOINED)
public class PessoaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="COD_PESSOA")
	private int id;
	
	@Column(name="NOME")	
	private String nome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="ESTADO_CIVIL")
	private String estadoCivil;
	
	@Column(name="TELEFONE_RESIDENCIAL")
	private String telefoneResidencial;
	
	@Column(name="CELULAR")
	private String celular;
	
	@Column(name="TELEFONE_COMERCIAL")
	private String telefoneComercial;
	
	@OneToOne
	@JoinColumn(name="COD_ENDERECO")
	private EnderecoBean endereco;

	//Constructor
	public PessoaBean(){
		this.endereco = new EnderecoBean();
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

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public EnderecoBean getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoBean endereco) {
		this.endereco = endereco;
	}

}
