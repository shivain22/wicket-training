package com.gel.wicket_training.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gel.wicket_training.entities.Person;
import com.gel.wicket_training.hibernate.HibernateUtil;


public class PersonDao implements IPersonDao<Person, Long> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public PersonDao() {
		
	}

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Person entity) {
		getCurrentSession().persist(entity);
	}

	public void update(Person entity) {
		getCurrentSession().update(entity);
	}

	public Person findById(Long id) {
		Person person = (Person) getCurrentSession().get(Person.class, id);
		return person; 
	}

	public void delete(Person entity) {
		getCurrentSession().remove(entity);
	}

	public List<Person> findAll() {
		List<Person> persons = getCurrentSession().createQuery("from Person",Person.class).list();
		return persons;
	}

	public void deleteAll() {
		List<Person> entityList = findAll();
		for (Person entity : entityList) {
			delete(entity);
		}
	}
	public void merge(Person person) {
		getCurrentSession().merge(person);
	}
}