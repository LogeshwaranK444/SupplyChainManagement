package org.jsp.supplychainmanagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.supplychainmanagement.entity.Customer;
import org.jsp.supplychainmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	public Customer getCustomerById(int id) {
		Optional<Customer>customer=customerRepository.findById(id);
		if(customer.isPresent())
			return customer.get();
		else
			return null;
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer updateCustomer(Customer customer) {
		Optional<Customer>updateCustomer= customerRepository.findById(customer.getId());
		if(updateCustomer.isPresent()) {
			customerRepository.save(updateCustomer.get());
			return updateCustomer.get();
		}
		else
			return null;
	}

	public Customer deleteCustomer(int id) {
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
			customerRepository.delete(customer.get());
			return customer.get();
		}
		else
			return null;
	}
}
