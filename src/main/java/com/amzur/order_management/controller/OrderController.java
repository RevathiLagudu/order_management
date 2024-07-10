package com.amzur.order_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amzur.order_management.dto.request.OrderRequest;
import com.amzur.order_management.dto.response.OrderResponse;
import com.amzur.order_management.service.OrderService;
@RestController
@RequestMapping("/orders")
public class OrderController {
	 @Autowired
	    private OrderService orderService;

	    // Create an order: POST http://localhost:8080/orders
	    @PostMapping
	    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
	    	//System.out.println("Book IDs:"+ orderRequest.getBookIds());
	        return orderService.createOrder(orderRequest);
	    }
	    @PostMapping
	    public List<OrderResponse> getByUserId(@RequestBody Long userId) {
	        return orderService.getByUserId(userId);
	    }
	    
	    @GetMapping
	    public List<OrderResponse> getAllOrder() {
	        return orderService.getAllOrders();
	    }

}
