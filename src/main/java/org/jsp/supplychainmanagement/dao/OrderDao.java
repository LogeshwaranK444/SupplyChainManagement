package org.jsp.supplychainmanagement.dao;
import java.util.List;
import java.util.Optional;
import org.jsp.supplychainmanagement.entity.Customer;
import org.jsp.supplychainmanagement.entity.Order;
import org.jsp.supplychainmanagement.repository.CustomerRepository;
import org.jsp.supplychainmanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Order createOrder(Order order, int customer_id) {
		Optional<Customer>customer=customerRepository.findById(customer_id);
		if(customer.isPresent()) {
			order.setCustomer(customer.get());
			return orderRepository.save(order);
		}
		return null;
	}

	public Order getOrderById(int id) {
		Optional<Order> order=orderRepository.findById(id);
		if(order.isPresent())
			return order.get();
		else
			return null;
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public List<Order> getOrderByCustomerId(int customer_id) {
		Optional<Customer>customer= customerRepository.findById(customer_id);
		if(customer.isPresent())
			return orderRepository.getOrderByCustomerId(customer_id);
		else
			return null;
	}

	public Order getOrderByTrackingNumber(String trackingNumber) {
		Optional<Order>order=orderRepository.getOrderByTrackingNumber(trackingNumber);
		if(order.isPresent())
			return order.get();
		else
			return null;
	}

	public Order updateOrder(Order order) {
		Optional<Order>updateOrder=orderRepository.findById(order.getId());
		if(updateOrder.isPresent()) 
			return orderRepository.save(order);
		else
			return null;
	}

	public Order deleteOrder(int id) {
		Optional<Order>order=orderRepository.findById(id);
		if(order.isPresent()) {
			orderRepository.delete(order.get());
			return order.get();
		}
		else
			return null;
	}
}
