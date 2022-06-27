package com.cts.eauction.events;

public enum EventType {

	PLACEBID("PLACEBID"),UPDATEBID("UPDATEBID");
	
	private final String type;

	private EventType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}
