package com.cts.eauction.microservices.seller;

public enum CategoryEnum {

	PAINTING("Painting"),SCULPTOR("Sculptor"),ORNAMENTS("Ornament");
	
	private final String type;

	private CategoryEnum(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
