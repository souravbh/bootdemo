package com.example.mongoSnap;

import org.springframework.data.annotation.Id;

public class StateRepresentation {

	@Id
    private int id;

    private String name;
    @Override
	public String toString() {
		return "StateRepresentation [id=" + id + ", name=" + name
				+ ", abbreviation=" + abbreviation + "]";
	}

	private String abbreviation;

    public StateRepresentation() {}

    public StateRepresentation(int id, String name, String abbreviation) {
        this.id = id;
    	this.name = name;
        this.abbreviation = abbreviation;
    }

    
}
