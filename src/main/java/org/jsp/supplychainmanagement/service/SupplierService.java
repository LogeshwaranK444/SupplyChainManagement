package org.jsp.supplychainmanagement.service;
import java.util.List;
import java.util.Optional;
import org.jsp.supplychainmanagement.dao.SupplierDao;
import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Supplier;
import org.jsp.supplychainmanagement.exception.IdNotFoundException;
import org.jsp.supplychainmanagement.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

	@Autowired
	private SupplierDao supplierDao;

	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier){
		ResponseStructure<Supplier>responseStructure=new ResponseStructure<Supplier>();
		Supplier receiveSupplier=supplierDao.saveSupplier(supplier);
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(supplierDao.saveSupplier(receiveSupplier));

		return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id){
		ResponseStructure<Supplier>responseStructure=new ResponseStructure<Supplier>();
		Optional<Supplier>optional=supplierDao.getSupplierById(id);

		if(optional.isPresent()) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(optional.get());

			return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSuppliers() {
		List<Supplier>suppliers=supplierDao.getAllSuppliers();
		ResponseStructure<List<Supplier>>responseStructure=new ResponseStructure<List<Supplier>>();
		if(suppliers.size()>0) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("success");
			responseStructure.setData(suppliers);
			
			return new ResponseEntity<ResponseStructure<List<Supplier>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new DataNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier) {
		Supplier receiveSupplier=supplierDao.updateSupplier(supplier);
		ResponseStructure<Supplier>responseStructure=new ResponseStructure<Supplier>();
		
		if(receiveSupplier!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("success");
			responseStructure.setData(receiveSupplier);
			
			return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.CREATED);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(int id) {
		Supplier supplierId=supplierDao.deleteSupplier(id);
		ResponseStructure<Supplier>responseStructure=new ResponseStructure<Supplier>();
		if(supplierId!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(null);
			
			return new ResponseEntity<ResponseStructure<Supplier>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();

	}
}
