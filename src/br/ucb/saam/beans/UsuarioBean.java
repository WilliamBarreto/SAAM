package br.ucb.saam.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




/**
 * Esta classe � o modelo para um obejto do tipo Usuario
 * Sobreescreve o m�todo equals e hashCode
 *  
 * @author Thiago R. Pereira
 * @version 1.0
 * @since 2013
 *    
 */


@Entity
@Table(name="usuarios")
public class UsuarioBean implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id_usuario")
	private int id;

	@Column(name="usuario")
	private String nome;

	@Column(name="senha")
	private String senha;
	
	@Column(name="email")
	private String email;

	@ManyToOne()
	@JoinColumn(name="id_perfil")
	private PerfilBean perfil;





	//Constructor-------------------------------------------------------------------------

	public UsuarioBean(){
		setPerfil(new PerfilBean());
	}




	//Methods------------------------------------------------------------------------------

	@Override
	public boolean equals(Object object){

		UsuarioBean aux = (UsuarioBean) object;

		if(aux.getNome().equalsIgnoreCase(this.getNome()) && 
				aux.getSenha().equalsIgnoreCase(this.getSenha())){
			return true;
		}
		return false;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}



	


	// Getter and Setters----------------------------------------------------------------------

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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PerfilBean getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}
	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}






}
