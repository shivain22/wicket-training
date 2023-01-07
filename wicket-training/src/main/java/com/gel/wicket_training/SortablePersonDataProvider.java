package com.gel.wicket_training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import com.gel.wicket_training.entities.Person;
import com.gel.wicket_training.service.PersonService;


public class SortablePersonDataProvider extends SortableDataProvider<Person, String> implements IFilterStateLocator<PersonFilter>
{
	private static final long serialVersionUID = 507426745396537534L;
	private PersonFilter personFilter = new PersonFilter();
	PersonService personService = new PersonService();
	List<Person> persons = new ArrayList<>();
	int first=1;
	int count=10;
	int totalRows=0;
	public SortablePersonDataProvider()
	{
		setSort("firstName", SortOrder.ASCENDING);
		personService.openSession();
		this.totalRows = personService.countAll();
		personService.closeSession();
	}
	public SortablePersonDataProvider(int first, int count)
	{
		this.first=first;
		this.count=count;
		setSort("firstName", SortOrder.ASCENDING);
		personService.openSession();
		this.totalRows = personService.countAll();
		personService.closeSession();
		
	}

	@Override
	public Iterator<Person> iterator(long first, long count)
	{
		personService.openSession();
		this.persons = personService.findAll();
		personService.closeSession();
		return persons.iterator();
	}

	@Override
	public long size()
	{
		if(persons.size()==0)
			return this.totalRows;
		return persons.size();
	}

	@Override
	public IModel<Person> model(Person object)
	{
		return new DetachablePersonModel(object);
	}

	@Override
	public PersonFilter getFilterState()
	{
	    return personFilter;
	}

	@Override
	public void setFilterState(PersonFilter state)
	{
	    personFilter  = state;
	}
}
