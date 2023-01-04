package com.gel.wicket_training;

import org.apache.wicket.Page;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.apache.wicket.protocol.http.WebApplication;

import com.gel.wicket_training.service.PersonService;

public class WicketApplication extends  WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return BasePage.class;
	}
	private static PersonService personService;
	
	public static PersonService getPersonService() {
		if(personService==null) {
			personService = new PersonService();
		}
		return personService;
	}
	@Override
	public void init()
	{
		super.init();
		personService = new PersonService();
		// needed for the styling used by the quickstart
		getCspSettings().blocking()
			.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF)
			.add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.UNSAFE_INLINE)
			.add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.UNSAFE_INLINE)
			.add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.SELF)
			.add(CSPDirective.SCRIPT_SRC, CSPDirectiveSrcValue.UNSAFE_EVAL)
			.add(CSPDirective.STYLE_SRC, "https://fonts.googleapis.com/css")
			.add(CSPDirective.FONT_SRC, "https://fonts.gstatic.com");

		getResourceSettings().getResourceFinders().
	    add(new WebApplicationPath(getServletContext(),"/"));
		// add your configuration here
	}

}
