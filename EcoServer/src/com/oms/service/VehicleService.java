package com.oms.service;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.oms.bean.Vehicle;
import com.oms.db.IMediaDatabase;
import com.oms.db.JsonMediaDatabase;

@Path("/vehicles")
public class VehicleService {
	
	private IMediaDatabase mediaDatabase;
	
	public VehicleService() {
		mediaDatabase = JsonMediaDatabase.singleton();
	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Vehicle> getVehicles(@QueryParam("barcode") String barcode, @QueryParam("title") String title) {
		Vehicle vehicle = new Vehicle();
		vehicle.setBarcode(barcode);
		vehicle.setTitle(title);
		ArrayList<Vehicle> res = mediaDatabase.searchVehicle(vehicle);
		System.out.println(res);
		return res;
	}
}