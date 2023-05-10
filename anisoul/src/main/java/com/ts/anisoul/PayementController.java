package com.ts.anisoul;
import java.math.BigInteger;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/pg")
public class PayementController {

	private RazorpayClient client;
	private static final String SECRET_ID1 = "rzp_test_avvw7zDTbakRmq";
	private static final String SECRET_KEY1 = "7HqzroP1rBTHUPjs4Krf2pYh";
//	private static final String SECRET_ID2 = "rzp_test_J4fInjDpTX475d";
//	private static final String SECRET_KEY2 = "r8fNXAB78RmsVfdiQbWGwyjr";

	@RequestMapping(path = "/createOrder", method = RequestMethod.POST)
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderResponse response = new OrderResponse();
		try {

			if (orderRequest.getAmount().intValue() > 1000) {
				client = new RazorpayClient(SECRET_ID1, SECRET_KEY1);}

			Order order = createRazorPayOrder(orderRequest.getAmount());
			System.out.println("---------------------------");
			String orderId = (String) order.get("id");
			System.out.println("Order ID: " + orderId);
			System.out.println("---------------------------");
			response.setRazorpayOrderId(orderId);
			response.setApplicationFee("" + orderRequest.getAmount());
			if (orderRequest.getAmount().intValue() > 1000) {
				response.setSecretKey(SECRET_KEY1);
				response.setSecretId(SECRET_ID1);
				response.setPgName("razor1");
			} 

			return response;
		} catch (RazorpayException e) {
			e.printStackTrace();
		}

		return response;

	}

	private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {

		JSONObject options = new JSONObject();
		try {
			options.put("amount", amount.multiply(new BigInteger("100")));
			options.put("currency", "INR");
			options.put("receipt", "txn_123456");
			options.put("payment_capture", 1); //
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return client.orders.create(options);
	}
}
