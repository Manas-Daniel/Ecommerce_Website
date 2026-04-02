package com.portal.Ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDTO, Integer>{
	public List<ProductDTO> findByPriceGreaterThan(int price);
}
