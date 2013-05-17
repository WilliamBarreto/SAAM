package br.ucb.saam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ucb.saam.beans.VoluntarioBean;
import br.ucb.saam.factory.ConnectionFactory;

public class VoluntarioDAO extends GenericDAO<VoluntarioBean>{
	
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<VoluntarioBean> buscaInativos(){
		try {
			
			this.session = ConnectionFactory.getSession();
			Criteria criteria = this.session.createCriteria(VoluntarioBean.class);
			criteria.add(Restrictions.like("situacao", false));
		return criteria.list();
			
		} catch (Exception e){
		System.out.println(e);
			return null;
		}		
	}

}
