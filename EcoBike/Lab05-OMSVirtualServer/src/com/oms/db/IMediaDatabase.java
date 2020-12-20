package com.oms.db;

import java.util.ArrayList;

import com.oms.bean.Station;

public interface IMediaDatabase {
	public ArrayList<Station> searchStation(Station station);
}
