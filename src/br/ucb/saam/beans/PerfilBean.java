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

/** Classe para objetos do tipo Perfil, onde serão contidos, valores e métodos para o mesmo.
 *  Representa os possíveis perfis suportados pela aplicação.
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







}
