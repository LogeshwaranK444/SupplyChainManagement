package org.jsp.supplychainmanagement.repository;
import org.jsp.supplychainmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
