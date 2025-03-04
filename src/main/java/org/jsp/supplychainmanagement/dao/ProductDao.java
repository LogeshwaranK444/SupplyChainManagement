package org.jsp.supplychainmanagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.supplychainmanagement.entity.Order;
import org.jsp.supplychainmanagement.entity.Product;
import org.jsp.supplychainmanagement.entity.Supplier;
import org.jsp.supplychainmanagement.repository.OrderRepository;
import org.jsp.supplychainmanagement.repository.ProductRespository;
import org.jsp.supplychainmanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRespository productRespository;
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	public Product addProduct(int supplier_id, int order_id, Product product) {
		Optional<Supplier>supplier=supplierRepository.findById(supplier_id);
		Optional<Order>order=orderRepository.findById(order_id);
		if(supplier.isPresent()&&order.isPresent()) {
			product.setSupplier(supplier.get());
			product.setOrder(order.get());
			productRespository.save(product);
			return product;
		}
		else
			return null;
	}

	public Product getProductById(int id) {
		Optional<Product>product=productRespository.findById(id);
		if(product.isPresent())
			return product.get();
		else
			return null;
	}

	public List<Product> getAllProducts() {
		return productRespository.findAll();
	}

	public List<Product> getProductsBySupplierId(int supplier_id) {
		return productRespository.findProductsBySupplierId(supplier_id);
	}

	public Product deleteProduct(int id) {
		Optional<Product>product=productRespository.findById(id);
		if(product.isPresent()) {
			productRespository.delete(product.get());
			return product.get();
		}
		else
			return null;
	}
	
}
