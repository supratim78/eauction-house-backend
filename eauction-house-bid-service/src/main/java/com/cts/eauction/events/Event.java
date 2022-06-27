package com.cts.eauction.events;

import java.util.Date;
import java.util.UUID;

public abstract class Event {
    public final UUID id = UUID.randomUUID();
    public final Date created = new Date();
    public String eventType;
    
	public Event() {
		
	}
	
	public Event(String eventType) {
		super();
		this.eventType = eventType;
	}


	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public UUID getId() {
		return id;
	}
	public Date getCreated() {
		return created;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", created=" + created + ", eventType=" + eventType + "]";
	}
}
