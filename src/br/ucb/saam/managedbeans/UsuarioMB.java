package br.ucb.saam.managedbeans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;

import br.ucb.saam.beans.EnderecoBean;
import br.ucb.saam.beans.PerfilBean;
import br.ucb.saam.beans.PessoaBean;
import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.beans.VoluntarioBean;
import br.ucb.saam.dao.EnderecoDAO;
import br.ucb.saam.dao.PerfilDAO;
import br.ucb.saam.dao.PessoaDAO;
import br.ucb.saam.dao.UsuarioDAO;
import br.ucb.saam.dao.VoluntarioDAO;
import br.ucb.saam.util.EmailUtils;
import br.ucb.saam.util.JSFMensageiro;
import br.ucb.saam.util.Mensagem;




@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {


	private UsuarioBean usuario;
	private UsuarioDAO usuarioDAO;
	
	private PessoaBean pessoa;
	private PessoaDAO pessoaDAO;
	
	private EnderecoBean endereco;
	private EnderecoDAO enderecoDAO;
	
	private List<UsuarioBean> usuarios;
	private String email;
	private PerfilDAO perfilDAO;


	public UsuarioMB(){
		setUsuario(new UsuarioBean());
		setUsuarioDAO(new UsuarioDAO());
		setUsuarios(new ArrayList<UsuarioBean>());
		setEmail(new String());
		
		this.pessoa = new PessoaBean();
		this.endereco = new EnderecoBean();
		
		this.pessoaDAO = new PessoaDAO();
		this.enderecoDAO = new EnderecoDAO();
		this.perfilDAO = new PerfilDAO();
		
	}


	//Methods
	/**Metodo para buscar todos os usuário cadastrados no banco de dados
	 * 
	 * @return ArrayList<UsuarioBean>
	 */
	public  List<UsuarioBean> getListUsuarios(){
		return this.usuarios = this.usuarioDAO.findAll(UsuarioBean.class);
	}
	
	/**Metodo para autenticar o usuário no sistema.
	 *  
	 * @return String - Página que será redirecionada.
	 */
	public String login(){
		
		//Busca a lista de usuários gravados no banco de dados
		getListUsuarios();

		//Percorre a lista de usuários		
		for (UsuarioBean user : usuarios) {	
			
			//Compara se o usuário informado é igual ao da vez
			if(user.equals(this.usuario)){
				//Sicroniza o objeto usuário
				user = (UsuarioBean) usuarioDAO.buscarPorId(UsuarioBean.class, user.getId());				
				
				//Adiciona o usuário na Sessão
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", user);
				
				isAtendente(user);
				//Redireciona para Home(Menu de Funcionalidades)
			
				this.usuario = new UsuarioBean();
				return "/home/home";
			}
		}
		//Caso não encontre envia uma mensagem informando o problema		
		JSFMensageiro.info("Usuário ou Senha Incorreta");
		return "principal";
	}
	
	/**
	 * Metodo para verificar se o usuário é atendente. Caso seja atendente adiciona a area do atendente na sua sessão
	 * @param usuario
	 */
	
	public void isAtendente(UsuarioBean usuario){
		if(usuario.getPerfil().getId() == 2){
			VoluntarioBean voluntario = (VoluntarioBean) new VoluntarioDAO().buscarPorId(VoluntarioBean.class, usuario.getPessoa().getId());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("area",voluntario.getArea());
			voluntario = new VoluntarioBean();
		}
	}
	
	public String logout() throws IOException{
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
		return "principal";
	}
	public String relembraSenha(){
		return "relembraSenha";
	}

	public String relembrarSenha(){
		
		Mensagem mensagem = new Mensagem();
		
		getListUsuarios();
		for (UsuarioBean user : usuarios) {
			System.out.println(user.getPessoa().getEmail());
			if(email.equals(user.getPessoa().getEmail())){
		
				mensagem.setDestino(user.getPessoa().getEmail());
				mensagem.setTitulo("Credencias de Acesso - SAAM");
				mensagem.setMensagem("Prezado(a) "+user.getPessoa().getNome()+",\n\nConforme solicitado seguem informações de acesso:\n\nUsuario: "+user.getNome()+"\nSenha: "+user.getSenha()+" \n\nAtenciosamente,\n\n Associação das Mulheres Empreendedoras.");
								
				try {
					EmailUtils.enviaEmail(mensagem);
					JSFMensageiro.info("Sua senha será enviada em instantes. Acesse seu e-mail para visualizar");
					this.email = new String();
				} catch (EmailException ex){
					System.out.println("Erro! Ocorreu um erro ao enviar a mensagem"+ex);
				}
				
				return "relembraSenha";
			}
		}
		JSFMensageiro.info("Sua senha será enviada em instantes. Acesse seu e-mail para visualizar");
		this.email = new String();
		return "relembraUsario";
		
		
	}

	public String deletar(UsuarioBean usuario){
		this.usuarios.remove(usuario);
		return null;
	}


	public String salvar(){
		
		this.usuario.setPerfil((PerfilBean) perfilDAO.buscarPorId(PerfilBean.class, 1));
		enderecoDAO.saveOrUpdate(this.usuario.getPessoa().getEndereco());
		pessoaDAO.saveOrUpdate(this.usuario.getPessoa());
		usuarioDAO.saveOrUpdate(this.usuario);
	
		return "";
	}

	
	
	
	/*Neste método é necessário uma nova instância do usuário
	 *Para que o valor acessado pelo método getUsuário esteja null
	 */
	public String incluir(){
		this.usuario = new UsuarioBean();
		return "formUsuario";
	}
	
	public String principal(){
		return "principal";
	}

	public void cadastrarMulher(){

			if(isCadastrado()){
				JSFMensageiro.error("O e-mail informado já possui cadastro no sistema.");
			}else{
				enderecoDAO.saveOrUpdate(this.endereco);
				
				this.pessoa.setEndereco(endereco);				
				pessoaDAO.saveOrUpdate(this.pessoa);
				usuario.setPessoa(this.pessoa);
				
				usuario.setNome(this.pessoa.getEmail());
				usuario.setSenha(UsuarioBean.geraSenha());
				usuario.setPerfil((PerfilBean) perfilDAO.buscarPorId(PerfilBean.class, 5));
				
				usuarioDAO.saveOrUpdate(usuario);
				
				Mensagem msg = new Mensagem();
				msg.setDestino(this.usuario.getPessoa().getEmail());
				msg.setMensagem("Prezado(a) "+this.usuario.getPessoa().getNome()+", \n\n" +
								"Para ter acesso aos atendimentos, utilize as seguintes informações: \n\n" +
								"\t Usuário: "+this.usuario.getNome()+"\n"+
								"\t Senha: "+this.usuario.getSenha()+"\n\n" +
								"\nImportante:\n\n" +
								"\t1. Ao informar o login e senha, por favor, verifique se não há espaços em branco.\n" +
								"\t2. Evite copiar e colar o login e a senha, pois este procedimento, geralmente, " +
								"acrescenta um espaço em branco nos dados, dificultando seu acesso." +
								"\n\nAtenciosamente,\n\n" +
								"\nAssociação de Mulheres Empreendedoras.");
								
				msg.setTitulo("Cadastro - SAAM");
				
				enviarEmail(msg);				
				JSFMensageiro.info("Seu cadastro foi realizado com sucesso! As informações de acesso serão enviadas para o e-mail cadastrado");
				
				this.usuario = new UsuarioBean();
				this.endereco = new EnderecoBean();
				this.pessoa = new PessoaBean();
			}

	}
	
	public boolean isCadastrado(){
		for (PessoaBean p : pessoaDAO.findAll(PessoaBean.class)) {
			if(p.getEmail().equalsIgnoreCase(this.pessoa.getEmail())){
				return true;
			}
		}
		return false;
	}
	public void enviarEmail(Mensagem msg){
		try {
			EmailUtils.enviaEmail(msg);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//getters and setters
	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


	public List<UsuarioBean> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<UsuarioBean> usuarios) {
		this.usuarios = usuarios;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public PessoaBean getPessoa() {
		return pessoa;
	}


	public void setPessoa(PessoaBean pessoa) {
		this.pessoa = pessoa;
	}


	public EnderecoBean getEndereco() {
		return endereco;
	}


	public void setEndereco(EnderecoBean endereco) {
		this.endereco = endereco;
	}


}
