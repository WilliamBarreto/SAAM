package br.ucb.saam.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ucb.saam.beans.FuncionalidadeBean;
import br.ucb.saam.dao.FuncionalidadeDAO;

//@FacesConverter(forClass=FuncionalidadeBean.class)
public class FuncionalidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		FuncionalidadeBean funcionalidade = new FuncionalidadeBean();
		funcionalidade = (FuncionalidadeBean) new FuncionalidadeDAO().buscarPorId(FuncionalidadeBean.class, Integer.parseInt(value));
		return funcionalidade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if(value instanceof FuncionalidadeBean){
			FuncionalidadeBean funcionalidade = (FuncionalidadeBean) value;
			String id = String.valueOf(funcionalidade.getId());
			return id;
		}
		return "";
	}

	
}
