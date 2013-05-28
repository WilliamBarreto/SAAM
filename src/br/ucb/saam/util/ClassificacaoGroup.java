package br.ucb.saam.util;

import br.ucb.saam.beans.ClassificacaoBean;

public class ClassificacaoGroup {

	private ClassificacaoBean classificacao;
	private int qtd;
	
	public ClassificacaoGroup(){
		this.classificacao = new ClassificacaoBean();
	}

	public ClassificacaoBean getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoBean classificacao) {
		this.classificacao = classificacao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
}
