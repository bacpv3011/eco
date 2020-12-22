package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.Station;
import com.oms.bean.Vehicle;
import com.oms.db.seed.Seed;

public class JsonMediaDatabase implements IMediaDatabase{
	private static IMediaDatabase singleton = new JsonMediaDatabase();
	
	private ArrayList<Station> stations = Seed.singleton().getStations();
	private ArrayList<Vehicle> vehicles = Seed.singleton().getVehicles();
	private JsonMediaDatabase() {
	}
	
	public static IMediaDatabase singleton() {
		return singleton;
	}

	@Override
	public ArrayList<Station> searchStation(Station station) {
		ArrayList<Station> res = new ArrayList<Station>();
		for (Station b: stations) {
			if (b.match(station)) {
				res.add(b);
			}
		}
		return res;
	}
	@Override
	public ArrayList<Vehicle> searchVehicle(Vehicle vehicle) {
		ArrayList<Vehicle> res = new ArrayList<Vehicle>();
		for (Vehicle b: vehicles) {
			if (b.match(vehicle)) {
				res.add(b);
			}
		}
		return res;
	}

}
