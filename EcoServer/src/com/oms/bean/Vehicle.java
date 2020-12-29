package com.oms.bean;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonTypeName("vehicle")
@JsonSubTypes( {@Type(value = EBike.class, name = "ebike") })
public class Vehicle {
	private String title;
	private String barcode;
	private float cost;
	private String name;
	private String typeBike;
	private float weight;
	private String licensePlate;
	private String manuafacturingDate;
	private String producer;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String title, String barcode, float cost) {
		super();

		this.title = title;
		this.barcode = barcode;
		this.cost = cost;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeBike() {
		return typeBike;
	}

	public void setTypeBike(String typeBike) {
		this.typeBike = typeBike;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getManuafacturingDate() {
		return manuafacturingDate;
	}

	public void setManuafacturingDate(String manuafacturingDate) {
		this.manuafacturingDate = manuafacturingDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		return  "title: " + this.title + ", barcode: " + this.barcode + ", cost: " + this.cost+
				", name: " + this.name + ", typeBike: " + this.typeBike + ", weight: " + this.weight+
				", licensePlate: " + this.licensePlate + ", manuafacturingDate: " + this.manuafacturingDate +
				", producer: " + this.producer;
	}
	
	
	public boolean match(Vehicle media) {
		if (media == null)
			return true;
		if (media.barcode != null && !media.barcode.equals(this.barcode) ) {
			return false;
		}
		if (media.title != null && !media.title.equals("") && !this.title.contains(media.title)) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehicle) {
			return this.barcode.equals(((Vehicle) obj).barcode);
		}
		return false;
	}
}