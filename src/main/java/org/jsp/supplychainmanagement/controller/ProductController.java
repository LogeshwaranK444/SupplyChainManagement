package org.jsp.supplychainmanagement.controller;
import java.util.List;

import org.jsp.supplychainmanagement.dto.ResponseStructure;
import org.jsp.supplychainmanagement.entity.Product;
import org.jsp.supplychainmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jsp/product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/{supplier_id}/{order_id}")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product,@PathVariable int supplier_id,@PathVariable int order_id){
		return productService.addProduct(supplier_id,order_id,product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/supplier/{supplier_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductsBySupplierId(@PathVariable int supplier_id){
		return productService.getProductsBySupplierId(supplier_id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id){
		return productService.deleteProduct(id);
	}
}
