package com.cts.eauction.events;

public enum EventType {

	DELETE("DELETE"),ADDNEW("ADDNEW");
	
	private final String type;

	private EventType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
