package com.oms.bean;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("station")
public class Station {
	private String id;
	
	private String title;

	private String name;
	
	private int numberOfBikes;
	private int numberOfEBikes;
	private int numberOfTwinBikes;
	private int numberOfEmptyDocks;

	private String address;
	
	public Station() {
		super();
	}

	public Station(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Station(String id, String title, String name, String address) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getNumberOfBikes() {
		return numberOfBikes;
	}

	public void setNumberOfBikes(int numberOfBikes) {
		this.numberOfBikes = numberOfBikes;
	}

	public int getNumberOfEBikes() {
		return numberOfEBikes;
	}

	public void setNumberOfEBikes(int numberOfEBikes) {
		this.numberOfEBikes = numberOfEBikes;
	}

	public int getNumberOfTwinBikes() {
		return numberOfTwinBikes;
	}

	public void setNumberOfTwinBikes(int numberOfTwinBikes) {
		this.numberOfTwinBikes = numberOfTwinBikes;
	}

	public int getNumberOfEmptyDocks() {
		return numberOfEmptyDocks;
	}

	public void setNumberOfEmptyDocks(int numberOfEmptyDocks) {
		this.numberOfEmptyDocks = numberOfEmptyDocks;
	}

	@Override
	public String toString() {
		return "id: " + this.id + ", title: " + this.title + ", name: " + this.name + 
				", address: " + this.address+ ", numberOfBikes: " + this.numberOfBikes+
				", numberOfEBikes: " + this.numberOfEBikes+ ", numberOfTwinBikes: " +
				this.numberOfTwinBikes+ ", numberOfEmptyDocks: " + this.numberOfEmptyDocks;
	}
	
	
	public boolean match(Station media) {
		if (media == null)
			return true;
		
		if (media.name != null && !media.name.equals("") && !this.name.contains(media.name)) {
			return false;
		}
		if (media.address != null && !media.address.equals("") && !this.address.contains(media.address)) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Station) {
			return this.id.equals(((Station) obj).id);
		}
		return false;
	}
}