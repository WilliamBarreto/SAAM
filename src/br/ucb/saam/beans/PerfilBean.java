package br.ucb.saam.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * 
 * 
 * 
 * */



@Entity
@Table(name="perfis")
public class PerfilBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	@Column(name="id_perfil")
	private int id;

	@Column()
	private String nome;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="perf_func", joinColumns=@JoinColumn(name="id_perfil"),
	inverseJoinColumns=@JoinColumn(name="id_funcionalidade"))
	private Collection<FuncionalidadeBean> funcionalidades;




	//Constructor------------------------------------------------------------------------------
	public PerfilBean(){

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

	public Collection<FuncionalidadeBean> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(Collection<FuncionalidadeBean> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}







}
