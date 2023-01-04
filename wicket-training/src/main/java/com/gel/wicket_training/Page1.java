package com.gel.wicket_training;

import java.util.List;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;

import com.gel.wicket_training.entities.Person;
import com.gel.wicket_training.entities.PersonAddress;
import com.gel.wicket_training.entities.PersonEmail;
import com.gel.wicket_training.entities.PersonMobileNumber;
import com.gel.wicket_training.service.PersonService;

public class Page1 extends BasePage {
	
	public Page1(final PageParameters page) throws Exception{
		PersonService personService = WicketApplication.getPersonService();
		List<Person> persons = personService.findAll();
		List<StringValue> personIds = page.getValues("person_id");
		Person person=new Person();
		if(personIds.size()>0) {
		 person = personService.findById(personIds.get(0).toLong());
		}
		AddEditForm addEditForm = new AddEditForm("addForm", person);
		add(addEditForm);
		add(new PersonList("personList", persons));
	}
}