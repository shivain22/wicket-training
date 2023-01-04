package com.gel.wicket_training;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class Page3 extends Page2 {
	public Page3() {
		add(new BookmarkablePageLink("page4", Page4.class));
		add(new Label("label3", "This is in the subclass of Page2 which is Page3"));
	}
}