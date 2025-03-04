package org.jsp.supplychainmanagement.service;
import java.util.List;

import org.jsp.supplychainmanagement.dao.OrderDao;
import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Order;
import org.jsp.supplychainmanagement.exception.DataNotFoundException;
import org.jsp.supplychainmanagement.exception.IdNotFoundException;
import org.jsp.supplychainmanagement.exception.TrackingNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public ResponseEntity<ResponseStructure<Order>> createOrder(Order order, int customer_id) {
		Order saveOrder=orderDao.createOrder(order, customer_id);
		ResponseStructure<Order>responseStructure=new ResponseStructure<Order>();

		if(saveOrder!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Created");
			responseStructure.setData(saveOrder);

			return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.CREATED);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Order>> getOrderById(int id) {
		Order order=orderDao.getOrderById(id);
		ResponseStructure<Order>responseStructure=new ResponseStructure<Order>();

		if(order!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(order);

			return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders() {
		List<Order>orders=orderDao.getAllOrders();
		ResponseStructure<List<Order>>responseStructure=new ResponseStructure<List<Order>>();

		if(orders.size()>0) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(orders);

			return new ResponseEntity<ResponseStructure<List<Order>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new DataNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Order>>> getOrderByCustomerId(int customer_id) {
		List<Order>orders=orderDao.getOrderByCustomerId(customer_id);
		ResponseStructure<List<Order>>responseStructure=new ResponseStructure<List<Order>>();

		if(orders!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(orders);

			return new ResponseEntity<ResponseStructure<List<Order>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Order>> getOrderByTrackingNumber(String trackingNumber) {
		Order order=orderDao.getOrderByTrackingNumber(trackingNumber);
		ResponseStructure<Order>responseStructure=new ResponseStructure<Order>();

		if(order!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(order);

			return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new TrackingNumberNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Order>> updateOrder(Order order) {
		Order updateOrder=orderDao.updateOrder(order);
		ResponseStructure<Order>responseStructure=new ResponseStructure<Order>();

		if(updateOrder!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updateOrder);

			return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.CREATED);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Order>> deleteOrder(int id) {
		Order order=orderDao.deleteOrder(id);
		ResponseStructure<Order>responseStructure=new ResponseStructure<Order>();

		if(order!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(order);

			return new ResponseEntity<ResponseStructure<Order>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
}
