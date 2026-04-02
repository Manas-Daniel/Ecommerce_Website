package com.portal.Ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	public List<ProductDTO> getAllProductsService(){
		List<ProductDTO> productDTO = productRepository.findAll();
		return productDTO;
	}
	
	public ProductDTO addProductService(ProductDTO productDTO){
		return productRepository.save(productDTO);
	}
	
	public List<ProductDTO> addProductsListService(List<ProductDTO> productDTO){
		return productRepository.saveAll(productDTO);
	}
	
	public List<ProductDTO> getByPrice (ProductDTO productDTO){
		return productRepository.findByPriceGreaterThan(productDTO.getPrice());
			
	}
}
