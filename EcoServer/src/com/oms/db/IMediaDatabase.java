package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.Station;
import com.oms.bean.Vehicle;

public interface IMediaDatabase {
	public ArrayList<Station> searchStation(Station station);

	public ArrayList<Vehicle> searchVehicle(Vehicle vehicle);
}
