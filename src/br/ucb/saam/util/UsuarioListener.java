package br.ucb.saam.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import br.ucb.saam.beans.UsuarioBean;

public class UsuarioListener implements HttpSessionAttributeListener{

	static List<UsuarioBean> usuariosLogados;
	
	
	public UsuarioListener() {
		usuariosLogados = new ArrayList<UsuarioBean>();
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute added : " + attributeName + " : " + attributeValue);
		if(attributeName.equals("usuario")){
			usuariosLogados.add((UsuarioBean) attributeValue);
		}
		System.out.println("Lista de Usuarios Logados");
		
		for (UsuarioBean user : usuariosLogados) {
			System.out.println(user.getId());
			System.out.println(user.getNome());
			System.out.println(" ---- ---- -----");
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute removed : " + attributeName + " : " + attributeValue);
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute replaced : " + attributeName + " : " + attributeValue);
		
	}
	
	public static List<UsuarioBean> getUsuariosLogados(){
		return usuariosLogados;
	}
}
