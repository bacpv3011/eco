package com.oms.bean;


public class EBike extends Vehicle {
	private String batteryPercentage;
	private int loadCycles;
	private String usageTimeRemaining;
	public EBike() {
		super();
	}

    
	public String getBatteryPercentage() {
		return batteryPercentage;
	}


	public void setBatteryPercentage(String batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}


	public int getLoadCycles() {
		return loadCycles;
	}


	public void setLoadCycles(int loadCycles) {
		this.loadCycles = loadCycles;
	}


	public String getUsageTimeRemaining() {
		return usageTimeRemaining;
	}


	public void setUsageTimeRemaining(String usageTimeRemaining) {
		this.usageTimeRemaining = usageTimeRemaining;
	}


	@Override
	public String toString() {
		return super.toString()+", batteryPercentage: " + this.batteryPercentage + ", loadCycles: " + this.loadCycles +"usageTimeRemaining: " + this.usageTimeRemaining;
	}
	
	@Override
	public boolean match(Vehicle media) {
		if (media == null)
			return true;
		
		
		boolean res = super.match(media);
		if (!res) {
			return false;
		}
		
		if (!(media instanceof EBike))
			return false;
		return true;
	}
}
