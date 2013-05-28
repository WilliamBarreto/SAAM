package br.ucb.saam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ucb.saam.beans.FuncionalidadeBean;
import br.ucb.saam.beans.PaginaBean;
import br.ucb.saam.factory.ConnectionFactory;

public class PaginaDAO extends GenericDAO<PaginaBean>{

	Session session;

	@SuppressWarnings("unchecked")
	public List<PaginaBean> findAllByFuncionalidade(FuncionalidadeBean f){

		this.session = ConnectionFactory.getSession();
		Criteria criteria = this.session.createCriteria(PaginaBean.class);
		criteria.add(Restrictions.like("funcionalidade", f));
		return criteria.list();
	}
}
