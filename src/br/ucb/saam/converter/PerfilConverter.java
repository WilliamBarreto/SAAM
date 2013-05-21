package br.ucb.saam.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.saam.beans.PerfilBean;
import br.ucb.saam.dao.PerfilDAO;

@FacesConverter(value="converterPerfil")
public class PerfilConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		PerfilBean perfil = new PerfilBean();
		perfil = (PerfilBean) new PerfilDAO().buscarPorId(PerfilBean.class, Integer.parseInt(value));
		return perfil;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof PerfilBean){
			PerfilBean perfil = (PerfilBean) value;
			String id = String.valueOf(perfil.getId());
			return id;
		}
		return "";
	}

}
