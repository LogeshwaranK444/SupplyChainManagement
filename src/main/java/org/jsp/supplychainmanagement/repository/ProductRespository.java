package org.jsp.supplychainmanagement.repository;
import java.util.List;
import org.jsp.supplychainmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRespository extends JpaRepository<Product, Integer>{
	
	@Query("select s.products from Supplier s where s.id=?1")
	List<Product> findProductsBySupplierId(int id);
}
