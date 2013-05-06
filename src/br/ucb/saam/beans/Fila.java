package br.ucb.saam.beans;

import java.util.LinkedList;
import java.util.List;

public class Fila {

	private List<ItemFila> itens = new LinkedList<ItemFila>();
		
	public List<ItemFila> getItens() {
		return itens;
	}

	public void setItens(List<ItemFila> itens) {
		this.itens = itens;
	}

	public void insere(ItemFila item){
		this.itens.add(item);
	}
	
	public ItemFila remove(){
		return this.itens.remove(0);
	}
	
	public boolean vazia(){
		return this.itens.size() == 0;
	}
	
	public int posicao(UsuarioBean usuario){
		int i;
		int posicao = 0;
		
		for (i=0; i<this.itens.size(); i++) {
			
			if(itens.get(i).getUsuario().getNome().equals(usuario.getNome())){
				posicao = i + 1;
			}			      
		}
		
		return posicao;
	}	
	
	
}
