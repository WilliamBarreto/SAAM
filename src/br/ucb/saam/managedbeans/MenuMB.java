package br.ucb.saam.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(name="menuMB")
@RequestScoped
public class MenuMB {

	
	private String resultado;
	//private List<FuncionalidadeBean> funcionalidades;
	//private FuncionalidadeDAO funciDAO;


	public MenuMB(){
		//this.funcionalidades = new ArrayList<FuncionalidadeBean>();
		//this.funciDAO = new FuncionalidadeDAO();
	}


	public String navegar(){	
		return resultado;
	}


	public void executaMenu(ActionEvent event){

		int idFuncionalidade = (Integer) event.getComponent().getAttributes().get("funcionalidade");
		System.out.println("Id da Funcionalidade: "+idFuncionalidade);
		this.resultado = getPagina(idFuncionalidade);
		
	}
	
	private String getPagina(int id){
		 
		 String pagina = new String();
		 
		 switch ( id ) {
			case 1:
				pagina = "atendimento/index";
				break;
			case 2:
				pagina = "atendimento/iniciarAtendimento";
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
				pagina = "/usuario/manterUsuarios";
				break;
			case 7:
				pagina = "/perfil/index";
				break;
			case 8:
				pagina = new VoluntarioMB().index();
				break;
			case 9:
				pagina = "naoProgramado";
				break;
			case 10:
				pagina = "perguntaFrequente/index";
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
	

}
