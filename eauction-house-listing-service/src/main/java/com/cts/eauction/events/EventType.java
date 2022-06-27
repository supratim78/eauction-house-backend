package com.cts.eauction.events;

public enum EventType {

	DELETE("DELETE"),ADDNEW("ADDNEW"), PLACEBID("PLACEBID"),UPDATEBID("UPDATEBID");
	
	private final String type;

	private EventType(String type) {
		this.type = type;
	}

	public final String getType() {
		return type;
	}
	
	
	
}
