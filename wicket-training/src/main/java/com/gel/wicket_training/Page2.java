package com.gel.wicket_training;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Page2 extends BasePage {
	public Page2() {
		add(new BookmarkablePageLink("page3", Page3.class));
		add(new Label("label2", "This is in the subclass Page2"));
	}
}