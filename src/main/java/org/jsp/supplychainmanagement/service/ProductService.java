package org.jsp.supplychainmanagement.service;
import java.util.List;

import org.jsp.supplychainmanagement.dao.ProductDao;
import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Product;
import org.jsp.supplychainmanagement.exception.DataNotFoundException;
import org.jsp.supplychainmanagement.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> addProduct(int supplier_id,int order_id, Product product) {
		Product receivedProduct= productDao.addProduct(supplier_id,order_id,product);
		ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();

		if(receivedProduct!=null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(receivedProduct);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product=productDao.getProductById(id);
		ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();

		if(product!=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(product);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		List<Product>products=productDao.getAllProducts();
		ResponseStructure<List<Product>>responseStructure=new ResponseStructure<List<Product>>();

		if(products.size()>0) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(products);

			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new DataNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getProductsBySupplierId(int supplier_id) {
		List<Product>products=productDao.getProductsBySupplierId(supplier_id);
		ResponseStructure<List<Product>>responseStructure=new ResponseStructure<List<Product>>();

		if(products.size()>0) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(products);

			return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure, HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product= productDao.deleteProduct(id);
		ResponseStructure<Product>responseStructure=new ResponseStructure<Product>();

		if(product!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(null);

			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
}
