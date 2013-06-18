package br.ucb.saam.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ucb.saam.beans.LogBean;
import br.ucb.saam.factory.ConnectionFactory;

public class LogDAO extends GenericDAO<LogBean>{

	private Session session;


	@SuppressWarnings("unchecked")
	public List<LogBean> buscarIntervalo(Date dataInicio, Date dataFim){

		ArrayList<LogBean>  lista = new ArrayList<LogBean>();

		if(dataFim != null && dataInicio != null){
			System.out.println(dataInicio+" - "+dataFim);}

		try {
			this.session = ConnectionFactory.getSession();
			Criteria criteria = this.session.createCriteria(LogBean.class);
			criteria.add(Restrictions.le("data", dataFim));
			criteria.add(Restrictions.ge("data", dataInicio));
			lista = (ArrayList<LogBean>) criteria.list();
		} catch (Exception e) {
			lista = null;
		}finally{
			this.session.close();
		}
		return lista;
	}


}