package br.ucb.saam.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/** Classe para objetos do tipo Perfil, onde ser�o contidos, valores e m�todos para o mesmo.
 *  Representa os poss�veis perfis suportados pela aplica��o.
 *  
 * @author William Barreto
 * @version 1.0
 * @since 2013
 *
 */

@Entity
@Table(name="perfis")
public class PerfilBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name="COD_PERFIL")
	private int id;

	@Column(name="NOME")
	private String nome;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="perf_func", joinColumns=@JoinColumn(name="COD_PERFIL"),
	inverseJoinColumns=@JoinColumn(name="COD_FUNCIONALIDADE"))
	private List<FuncionalidadeBean> funcionalidades;




	//Constructor------------------------------------------------------------------------------
	public PerfilBean(){
		this.funcionalidades = new ArrayList<FuncionalidadeBean>();
	}



	//Methods----------------------------------------------------------------------------------








	//Getter and Setters------------------------------------------------------------------

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

	public List<FuncionalidadeBean> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(List<FuncionalidadeBean> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PerfilBean other = (PerfilBean) obj;
		if (id != other.id)
			return false;
		return true;
	}






}
