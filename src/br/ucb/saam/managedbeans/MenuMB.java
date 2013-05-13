package br.ucb.saam.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ucb.saam.beans.FuncionalidadeBean;


@ManagedBean(name="menuMB")
@RequestScoped
public class MenuMB {

	private FuncionalidadeBean funcionalidade;
	private String resultado;

	public MenuMB(){
		setFuncionalidade(new FuncionalidadeBean());
	}

	public String navegar(){
		this.resultado = getPagina(this.funcionalidade.getId());
		return this.resultado;
	}
	
	private String getPagina(int id){
		 
		 String pagina = new String();
		 
		 switch ( id ) {
			case 1:
				pagina = "solicitar";
				break;
			case 2:
				pagina = "iniciarAtendimento";
				break;
			case 3:
				pagina = "naoProgramado";
				break;
			case 4:
				pagina = "naoProgramado";
				break;			
			case 5:
				pagina = "naoProgramado";
				break;
			case 6:
				// Manter Usuarios
				System.out.println("Caso 6");
				pagina = "usuario";
				break;
			case 7:
				pagina = "perfil";
				break;
			case 8:
				pagina = "voluntario";
				break;
			case 9:
				pagina = "naoProgramado";
				break;
			case 10:
				pagina = "perguntaFrequente";
				break;
			case 11:
				pagina = "naoProgramado";
				break;
			case 12:
				pagina = "naoProgramado";
				break;
			case 13:
				pagina = "naoProgramado";
				break;
			case 14:
				pagina = "naoProgramado";
				break;	
			default:
				break;
		}
		return pagina;
	}


	public FuncionalidadeBean getFuncionalidade() {
		return funcionalidade;
	}


	public void setFuncionalidade(FuncionalidadeBean funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	

}
