package com.oms.service;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.oms.bean.Station;
import com.oms.db.IMediaDatabase;
import com.oms.db.JsonMediaDatabase;

@Path("/stations")
public class MediaService {
	
	private IMediaDatabase mediaDatabase;
	
	public MediaService() {
		mediaDatabase = JsonMediaDatabase.singleton();
	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Station> getStations(@QueryParam("name") String name, @QueryParam("address") String address) {
		Station station = new Station();
		station.setAddress(address);
		station.setName(name);
		ArrayList<Station> res = mediaDatabase.searchStation(station);
		return res;
	}
}