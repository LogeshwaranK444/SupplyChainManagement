package org.jsp.supplychainmanagement.repository;
import java.util.List;
import java.util.Optional;

import org.jsp.supplychainmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	@Query("select c.orders from Customer c where c.id=?1")
	List<Order> getOrderByCustomerId(int id);
	
	@Query("select o from Order o where o.trackingNumber=?1")
	Optional<Order> getOrderByTrackingNumber(String trackingNumber);
}
