package com.eco.api;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.eco.bean.Station;
import com.eco.bean.Vehicle;

public class EcoApi {
	public static final String PATH = "http://localhost:8080/";
	
	private Client client;
	
	public EcoApi() {
		client = ClientBuilder.newClient();
	}
	
	public ArrayList<Station> getStations(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("stations");
		
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Station> res = response.readEntity(new GenericType<ArrayList<Station>>() {});
		System.out.println(res);
		return res;
	}
	
	public ArrayList<Vehicle> getVehicles(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("vehicles");
		
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Vehicle> res = response.readEntity(new GenericType<ArrayList<Vehicle>>() {});
		System.out.println(res);
		return res;
	}
}
