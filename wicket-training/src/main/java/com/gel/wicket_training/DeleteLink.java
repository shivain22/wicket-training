package com.gel.wicket_training;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;

import com.gel.wicket_training.entities.Person;
import com.gel.wicket_training.service.PersonService;

public class DeleteLink extends Link<Person> {

	ListItem item;
	Person person;
	public DeleteLink(String id, ListItem<Person> item) {
		super(id);
		this.item = item;
		this.person=item.getModelObject();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		PersonService personService = new PersonService();
		personService.delete(person.getId());
		setResponsePage(BasicCrudPage.class);
	}

}
