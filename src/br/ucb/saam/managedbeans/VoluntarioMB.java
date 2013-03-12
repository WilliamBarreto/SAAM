package br.ucb.saam.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucb.saam.beans.AreaBean;
import br.ucb.saam.beans.VoluntarioBean;
import br.ucb.saam.dao.AreaDAO;
import br.ucb.saam.dao.VoluntarioDAO;

@ManagedBean
@SessionScoped
public class VoluntarioMB {

	private VoluntarioBean voluntario;
	private List<AreaBean> areas;
	

// Constructor
	
	public VoluntarioMB(){
		setVoluntario(new VoluntarioBean());
		setAreas(new AreaDAO().findAll(AreaBean.class));
	}
	
// Methods
	
	public String cadastrar(){
		
		System.out.println("Nome: " + voluntario.getNome());
		System.out.println("Email: "+voluntario.getEmail());
		System.out.println("Telefone : "+voluntario.getTelefone());
		System.out.println("Sexo: "+voluntario.getSexo());
		System.out.println("-------------------------");
		
		System.out.println("ID : "+voluntario.getArea().getId());
		System.out.println("NOME : "+voluntario.getArea().getNome());

		new VoluntarioDAO().saveOrUpdate(voluntario);
		
		this.voluntario = new VoluntarioBean();
		return "sucess";
	}
	
	
// Getters and Setters
	public List<AreaBean> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}

	public VoluntarioBean getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(VoluntarioBean voluntario) {
		this.voluntario = voluntario;
	}
	

}
