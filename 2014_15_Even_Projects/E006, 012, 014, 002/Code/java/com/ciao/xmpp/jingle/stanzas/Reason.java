package com.ciao.xmpp.jingle.stanzas;

import com.ciao.xml.Element;

public class Reason extends Element {
	private Reason(String name) {
		super(name);
	}

	public Reason() {
		super("reason");
	}
}
