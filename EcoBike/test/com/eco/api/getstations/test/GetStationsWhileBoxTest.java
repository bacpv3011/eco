package com.eco.api.getstations.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import com.oms.bean.Order;
import com.oms.bean.OrderLine;
import com.oms.components.cart.controller.CartController;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetStationsWhileBoxTest {
	private String expectedResult;
	private String address;
    private CartController controller = new CartController();
	
    private Order order;
	private  ArrayList<OrderLine> orderLine;
	public GetStationsWhileBoxTest(String address,ArrayList<OrderLine> orderLine, String expectedResult) {
		super();
		this.address = address;
		this.orderLine = orderLine;
		this.expectedResult = expectedResult;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		
		ArrayList<OrderLine> orderLine2 = new ArrayList<OrderLine>();
		orderLine2 = new ArrayList<OrderLine>();
		orderLine2.add(new OrderLine("4","media4",2,120000f,1.2f));
		orderLine2.add(new OrderLine("5","media5",1,150000f,1.2f));
		return Arrays.asList(new Object[][] { 
			{ "HN",null, "Your cart has 0 products. Total Cost: 0.0" },             // orderLine == null
			{ "Hcm",orderLine2, "Your cart has 2 products. Total Cost: 417000.0" },      // orderLine != null
 			{ "Thái Bình",orderLine2, "Your cart has 2 products. Total Cost: 437500.0"}  //
		});
	}
	
	@Test
	public void testGetPresentationText() {
		order = controller.getOrder();
		order.setCustomerAddress(address);
		order.setOrderLines(orderLine);
		
		String cost = controller.getPresentationText();
        assertEquals("Cost = "+cost + "-rs = " +expectedResult,cost,expectedResult);
	}
}