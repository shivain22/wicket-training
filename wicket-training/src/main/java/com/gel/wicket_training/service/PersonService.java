package com.gel.wicket_training.service;

import java.util.List;

import com.gel.wicket_training.dao.PersonDao;
import com.gel.wicket_training.entities.Person;

public class PersonService {
 
    private static PersonDao personDao;
 
    public PersonService() {
    	personDao = new PersonDao();
    }
 
	public Person persist(Person entity) {
        personDao.openCurrentSessionwithTransaction();
        personDao.persist(entity);
        personDao.closeCurrentSessionwithTransaction();
        return entity;
    }
 
    public void update(Person entity) {
        personDao.openCurrentSessionwithTransaction();
        personDao.update(entity);
        personDao.closeCurrentSessionwithTransaction();
    }

    public void update1(Person entity) {
        personDao.openCurrentSessionwithTransaction();
        Person person = personDao.findById(entity.getId());
        person.setFirstName(entity.getFirstName());
        person.setLastName(entity.getLastName());
        personDao.update(person);
        personDao.closeCurrentSessionwithTransaction();
    }
    
    public Person findById(Long id) {
        personDao.openCurrentSession();
        Person book = personDao.findById(id);
        personDao.closeCurrentSession();
        return book;
    }
 
    public void delete(Long id) {
        personDao.openCurrentSessionwithTransaction();
        Person book = personDao.findById(id);
        personDao.delete(book);
        personDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Person> findAll() {
        personDao.openCurrentSession();
        List<Person> books = personDao.findAll();
        personDao.closeCurrentSession();
        return books;
    }
 
    public void deleteAll() {
        personDao.openCurrentSessionwithTransaction();
        personDao.deleteAll();
        personDao.closeCurrentSessionwithTransaction();
    }
 
    public PersonDao personDao() {
        return personDao;
    }
}