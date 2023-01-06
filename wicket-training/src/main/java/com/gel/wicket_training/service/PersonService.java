package com.gel.wicket_training.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gel.wicket_training.dao.PersonDao;
import com.gel.wicket_training.entities.Person;
import com.gel.wicket_training.hibernate.HibernateUtil;

public class PersonService {
 
    private static PersonDao personDao;
 
    public PersonService() {
    	personDao = new PersonDao();
    }
    
    public Session openSession() {
    	return personDao.openCurrentSessionwithTransaction();
    }
    
    public void closeSession() {
    	personDao.closeCurrentSessionwithTransaction();
    }
    
	public Person persist(Person entity) {
        personDao.persist(entity);
        return entity;
    }
	public Person merge(Person entity) {
        personDao.merge(entity);
        return entity;
    }
 
    public void update(Person entity) {
        personDao.update(entity);
    }
    
    public Person findById(Long id) {
        return  personDao.findById(id);
    }
 
    public void delete(Person person) {
        personDao.delete(person);
    }
 
    public List<Person> findAll() {
        return personDao.findAll();
    }
 
    public void deleteAll() {
        personDao.deleteAll();
    }
 
    public PersonDao personDao() {
        return personDao;
    }
}