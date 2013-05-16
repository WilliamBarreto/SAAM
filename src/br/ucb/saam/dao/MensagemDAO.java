package br.ucb.saam.dao;

import java.util.List;

import br.ucb.saam.beans.MensagemBean;

public class MensagemDAO extends GenericDAO<MensagemBean>{
	
	public void saveOrUpdateMensagens (List<MensagemBean> mensagens){
		for (MensagemBean mensagemBean : mensagens) {
			this.saveOrUpdate(mensagemBean);
		}
	}
}
