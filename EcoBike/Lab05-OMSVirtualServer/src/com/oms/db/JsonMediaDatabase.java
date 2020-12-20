package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.Station;
import com.oms.db.seed.Seed;

public class JsonMediaDatabase implements IMediaDatabase{
	private static IMediaDatabase singleton = new JsonMediaDatabase();
	
	private ArrayList<Station> stations = Seed.singleton().getStations();
	
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

}
