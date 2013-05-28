package br.ucb.saam.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Chat {

	private UsuarioBean atendente;
	private String canalAtendente;
	private String canalAtendido;
	private UsuarioBean atendido;
	private List<MensagemBean> msgs;
	private Date data;
		
	public Chat(){
		
	}
	
	public Chat(UsuarioBean atendente,String canalAtendente, UsuarioBean atendido,String canalAtendido,Date data){
		setAtendente(atendente);
		setAtendido(atendido);
		setData(data);
		setCanalAtendente(canalAtendente);
		setCanalAtendido(canalAtendido);
		this.msgs = new ArrayList<MensagemBean>();
	}
	
	public UsuarioBean getAtendente() {
		return atendente;
	}
	public void setAtendente(UsuarioBean atendente) {
		this.atendente = atendente;
	}
	public UsuarioBean getAtendido() {
		return atendido;
	}
	public void setAtendido(UsuarioBean atendido) {
		this.atendido = atendido;
	}
	public List<MensagemBean> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<MensagemBean> msgs) {
		this.msgs = msgs;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCanalAtendente() {
		return canalAtendente;
	}

	public void setCanalAtendente(String canalAtendente) {
		this.canalAtendente = canalAtendente;
	}

	public String getCanalAtendido() {
		return canalAtendido;
	}

	public void setCanalAtendido(String canalAtendido) {
		this.canalAtendido = canalAtendido;
	}

}
