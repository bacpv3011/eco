package com.oms.db.seed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.oms.bean.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Seed {
	private ArrayList<Station> stations;
	
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
	    
	}
	
	private ArrayList<Station> generateDataFromFile(String filePath){
		ArrayList<Station> res = new ArrayList<Station>();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = FileReader.read(filePath);
		System.out.println(json);
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
}
