package org.jsp.supplychainmanagement.controller;
import java.util.List;

import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Order;
import org.jsp.supplychainmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jsp/order")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/{customer_id}")
	public ResponseEntity<ResponseStructure<Order>> createOrder(@RequestBody Order order,@PathVariable int customer_id){
		return orderService.createOrder(order,customer_id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Order>> getOrderById(@PathVariable int id){
		return orderService.getOrderById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/customer/{customer_id}")
	public ResponseEntity<ResponseStructure<List<Order>>> getOrderByCustomerId(@PathVariable int customer_id){
		return orderService.getOrderByCustomerId(customer_id);
	}
	
	@GetMapping("/tracking")
	public ResponseEntity<ResponseStructure<Order>> getOrderByCustomerId(@RequestParam String trackingNumber){
		return orderService.getOrderByTrackingNumber(trackingNumber);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@RequestBody Order order){
		return orderService.updateOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(@PathVariable int id){
		return orderService.deleteOrder(id);
	}
}
