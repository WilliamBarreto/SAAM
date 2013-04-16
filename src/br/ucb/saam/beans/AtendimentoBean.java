package br.ucb.saam.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="atendimentos")
public class AtendimentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="COD_ATENDIMENTO")	
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="COD_ATENDENTE")
	private UsuarioBean atendente;
	
	@ManyToOne()
	@JoinColumn(name="COD_ATENDIDO")
	private UsuarioBean atendido;
	
	@ManyToOne()
	@JoinColumn(name="COD_TIPO_ATENDIMENTO")
	private TipoAtendimentoBean tipoAtendimento;
	
	@ManyToOne()
	@JoinColumn(name="COD_AVALIACAO")
	private AvaliacaoBean avaliacao;
	
	@ManyToOne()
	@JoinColumn(name="COD_AREA")	
	private AreaBean area;
	
	@Column(name="DATA")
	private Date data;
	
	@ManyToMany()
	@JoinTable(name="aten_mens", joinColumns=@JoinColumn(name="COD_ATENDIMENTO"),
	inverseJoinColumns=@JoinColumn(name="COD_MENSAGEM"))
	private List<MensagemBean> mensagens;
	
	//Constructor	
	public AtendimentoBean(){
		
	}

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public TipoAtendimentoBean getTipoAtendimento() {
		return tipoAtendimento;
	}
	public void setTipoAtendimento(TipoAtendimentoBean tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public AvaliacaoBean getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(AvaliacaoBean avaliacao) {
		this.avaliacao = avaliacao;
	}

	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public List<MensagemBean> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MensagemBean> mensagens) {
		this.mensagens = mensagens;
	}
	
	
}