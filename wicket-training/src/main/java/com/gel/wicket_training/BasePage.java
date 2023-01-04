package com.gel.wicket_training;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public  class BasePage extends WebPage {
	public BasePage() {
		add(new BookmarkablePageLink("page1", Page1.class));
		add(new BookmarkablePageLink("page2", Page2.class));
		add(new Label("footer", "This is the footer"));
		add(new Label("hello","Hello World...."));
	}
}