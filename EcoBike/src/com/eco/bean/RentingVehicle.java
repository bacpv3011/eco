package com.eco.bean;

public class RentingVehicle {
    private Vehicle vehicle;
    public RentingVehicle() {
    	if(vehicle == null)
    	    vehicle = new Vehicle();
    }

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
    	return vehicle;
    }
}
