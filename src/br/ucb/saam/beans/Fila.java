package br.ucb.saam.beans;

import java.util.LinkedList;
import java.util.List;

public class Fila {

	private List<UsuarioBean> usuarios = new LinkedList<UsuarioBean>();
	
	public List<UsuarioBean> getUsuarios(){
		return this.usuarios;
	}
	
	public void insere(UsuarioBean usuario){
		this.usuarios.add(usuario);
	}
	
	public UsuarioBean remove(){
		return this.usuarios.remove(0);
	}
	
	public boolean vazia(){
		return this.usuarios.size() == 0;
	}
	
	public int posicao(UsuarioBean usuario){
		int i;
		int posicao = 0;
		
		for (i=0; i<this.usuarios.size(); i++) {
			
			if(usuarios.get(i).getNome().equals(usuario.getNome())){
				posicao = i + 1;
			}			      
		}
		
		return posicao;
	}	
	
	
}
