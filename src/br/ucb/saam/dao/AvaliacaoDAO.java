package br.ucb.saam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ucb.saam.beans.AvaliacaoBean;
import br.ucb.saam.factory.ConnectionFactory;

public class AvaliacaoDAO extends GenericDAO<AvaliacaoBean>{

	Session session;
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoBean> findAllByClassificacao(int id){
		this.session = ConnectionFactory.getSession();
		Criteria criteria = this.session.createCriteria(AvaliacaoBean.class);
		criteria.add(Restrictions.like("classificacao.id", id));
		return criteria.list();
	}


}
