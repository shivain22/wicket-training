package com.gel.wicket_training;

import org.apache.wicket.markup.html.basic.Label;

public class Page4 extends Page3 {
	public Page4() {
		add(new Label("label4", "This is in the subclass of Page3 which is Page4"));
	}
}