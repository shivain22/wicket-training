package com.gel.wicket_training;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import com.gel.wicket_training.entities.Person;

public  class IndexPage extends WebPage {
	private Person selected;
	public IndexPage() {
		add(new BookmarkablePageLink("basicCrudPage", BasicCrudPage.class));
		add(new BookmarkablePageLink("ajaxPage", AjaxPage.class));
		add(new BookmarkablePageLink("ajaxFormInTabbedPanel", AjaxFormInTabbedPanel.class));
		add(new BookmarkablePageLink("dataTablePage", DataTablePage.class));
		add(new BookmarkablePageLink("simpleDataTablePage", SimpleDataTablePage.class));
		add(new Label("footer", "This is the footer"));
		add(new Label("hello","Apache Wicket Training"));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
	    super.renderHead(response);

	    response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings()
	        .getJQueryReference()));  
	}
	
}