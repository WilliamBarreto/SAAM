package br.ucb.saam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ucb.saam.beans.UsuarioBean;
import br.ucb.saam.factory.ConnectionFactory;


public class UsuarioDAO extends GenericDAO<UsuarioBean>{					
	Session session;

	@SuppressWarnings("unchecked")
	public List<UsuarioBean> buscaAtendentes(){
		try {

			this.session = ConnectionFactory.getSession();
			Criteria criteria = this.session.createCriteria(UsuarioBean.class);
			criteria.add(Restrictions.eq("perfil.id", 2)).setFetchMode("perfil.funcionalidades", FetchMode.SELECT);
			return criteria.list();

		} catch (Exception e){
			System.out.println(e);
			return null;
		}		
	}
}
