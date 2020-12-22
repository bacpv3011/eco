package com.oms.db.seed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.oms.bean.Station;
import com.oms.bean.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Seed {
	private ArrayList<Station> stations;
	private ArrayList<Vehicle> vehicles;
	private static Seed singleton = new Seed();
	
	private Seed() {
		start();
	}
	
	public static Seed singleton() {
		return singleton;
	}
	
	private void start() {
		stations = new ArrayList<Station>();
		stations.addAll(generateDataFromFile( new File(getClass().getResource("./stations.json").getPath()).toString()));
	    
		vehicles = new ArrayList<Vehicle>();
		vehicles.addAll(generateDataFromFile1( new File(getClass().getResource("./ebike.json").getPath()).toString()));
		
	}
	private ArrayList<Vehicle> generateDataFromFile1(String filePath){
		ArrayList<Vehicle> res = new ArrayList<Vehicle>();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = FileReader.read(filePath);
		System.out.println(json);
		try {
			res = mapper.readValue(json, new TypeReference<ArrayList<Vehicle>>() { });
		    
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);

		}
		
		return res;
	}
	
	private ArrayList<Station> generateDataFromFile(String filePath){
		ArrayList<Station> res = new ArrayList<Station>();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = FileReader.read(filePath);
		try {
			res = mapper.readValue(json, new TypeReference<ArrayList<Station>>() { });
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);

		}
		
		return res;
	}
	public static void main(String[] args) {
		Seed seed = new Seed();
		seed.start();
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}
}
