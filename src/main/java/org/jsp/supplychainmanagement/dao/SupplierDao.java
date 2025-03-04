package org.jsp.supplychainmanagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.supplychainmanagement.entity.Supplier;
import org.jsp.supplychainmanagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDao {

	@Autowired
	private SupplierRepository supplierRepository;

	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepository.findById(id);
	}

	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	public Supplier updateSupplier(Supplier supplier) {
		Optional<Supplier> findSupplier=supplierRepository.findById(supplier.getId());
		if(findSupplier.isPresent())
			return supplierRepository.save(supplier);
		else
			return null;
	}

	public Supplier deleteSupplier(int id) {
		Optional<Supplier> findSupplier=supplierRepository.findById(id);
		if(findSupplier.isPresent()) {
			supplierRepository.delete(findSupplier.get());
			return findSupplier.get();
		}
		else
			return null;
	}
}
