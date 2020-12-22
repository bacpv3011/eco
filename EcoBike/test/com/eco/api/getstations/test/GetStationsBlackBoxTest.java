package com.eco.api.getstations.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.eco.api.EcoApi;
import com.oms.bean.Book;
import com.oms.serverapi.MediaApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@RunWith(Parameterized.class)
public class GetStationsBlackBoxTest {
	private String name;
	private String address;
	
	private EcoApi api = new EcoApi();
	
	
	public GetStationsBlackBoxTest(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { 
			{ null , 4 },
			{ "D3", "Java Programming" }, 
		});
	}
	
	@Test
	public void testGetBooks() {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("title", bookTitle);
		
		ArrayList<Book> list= api.getBooks(params);
		assertTrue("No data", list.size() > 0);
		
		
		Book book = list.get(0);
		assertEquals("Eror in getBooks API!", book.getTitle(), expectedResult);
	}
}