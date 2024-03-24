package com.demo.bonisApplication.entities.enums;

public enum Status {

	WAYTING_PAYMENT(1),
	PAID(2),
	PRODUCING(3),
	DELLIVERED(4),
	CANCELLED(5);
	
	private int code;

	private Status(int code) {
		this.code = code;
	}


	public Integer getCode() {
		return code;
	}

	public static Status valueOf(int code) {
		for(Status value : Status.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}
}
