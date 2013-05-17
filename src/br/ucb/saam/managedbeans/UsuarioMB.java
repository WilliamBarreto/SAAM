package br.ucb.saam.managedbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.mail.EmailException;

import br.ucb.saam.beans.PerfilBean;
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
	private PessoaDAO pessoaDAO;
	private EnderecoDAO enderecoDAO;
	private List<UsuarioBean> usuarios;
	private String email;
	private PerfilDAO perfilDAO;


	public UsuarioMB(){
		setUsuario(new UsuarioBean());
		setUsuarioDAO(new UsuarioDAO());
		setUsuarios(new ArrayList<UsuarioBean>());
		setEmail(new String());
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
		if(usuario.getPerfil().getNome().equalsIgnoreCase("atendente")){
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


}
