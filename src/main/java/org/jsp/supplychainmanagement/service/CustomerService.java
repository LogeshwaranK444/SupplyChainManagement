package org.jsp.supplychainmanagement.service;
import java.util.List;

import org.jsp.supplychainmanagement.dao.CustomerDao;
import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Customer;
import org.jsp.supplychainmanagement.exception.DataNotFoundException;
import org.jsp.supplychainmanagement.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseEntity<ResponseStructure<Customer>> addCustomer(Customer customer) {
		Customer receiveCustomer=customerDao.addCustomer(customer);
		ResponseStructure<Customer>responseStructure=new ResponseStructure<Customer>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Created");
		responseStructure.setData(receiveCustomer);

		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id) {
		Customer customer=customerDao.getCustomerById(id);
		ResponseStructure<Customer>responseStructure=new ResponseStructure<Customer>();

		if(customer!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(customer);

			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
		List<Customer>customers=customerDao.getAllCustomers();
		ResponseStructure<List<Customer>>responseStructure=new ResponseStructure<List<Customer>>();

		if(customers.size()>0) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(customers);

			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new DataNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer) {
		Customer updateCustomer=customerDao.updateCustomer(customer);
		ResponseStructure<Customer>responseStructure=new ResponseStructure<Customer>();

		if(customer!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Created");
			responseStructure.setData(updateCustomer);

			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id) {
		Customer customer=customerDao.deleteCustomer(id);
		ResponseStructure<Customer>responseStructure=new ResponseStructure<Customer>();

		if(customer!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(null);

			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
}
