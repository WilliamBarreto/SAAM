package br.ucb.saam.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ucb.saam.factory.ConnectionFactory;

public abstract class GenericDAO<T> {

	private Session session;
	private Transaction transaction;




	public void saveOrUpdate(T object){

		try {
			this.session = ConnectionFactory.getSession();
			this.transaction = this.session.beginTransaction();
			this.session.saveOrUpdate(object);
			this.transaction.commit();
		} catch (Exception e) {
			this.transaction.rollback();
		}finally{
			this.session.close();
		}
	}


	@SuppressWarnings("unchecked")
	public List<T> findAll(Class classe){

		ArrayList<T>  lista = new ArrayList<T>();

		try {
			this.session = ConnectionFactory.getSession();
			Criteria criteria = this.session.createCriteria(classe);
			lista = (ArrayList<T>) criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		} catch (Exception e) {
			lista = null;
		}finally{
			this.session.close();
		}

		return lista;
	}



	public void delete(T object){

		try {

			this.session = ConnectionFactory.getSession();
			this.transaction = this.session.beginTransaction();
			this.session.delete(object);
			this.transaction.commit();	
		} catch (Exception e) {
			this.transaction.rollback();
		}finally{
			this.session.close();
		}
	}


	public Object buscarPorId(Class classe, int id){
		Object object = null;
		try {
			this.session = ConnectionFactory.getSession();
			object = session.get(classe, id);
		} catch (Exception e) {
			object = null;
		}finally{
			this.session.close();
		}
		return object;
	}



}
