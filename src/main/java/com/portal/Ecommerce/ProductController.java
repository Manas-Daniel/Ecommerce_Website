package com.portal.Ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService){
		this.productService = productService;
	}
	
	@PostMapping("/addProductsList")
	public ResponseEntity<List<ProductDTO>> addProductsList(@RequestBody List<ProductDTO> productDTO){
		return ResponseEntity.ok(productService.addProductsListService(productDTO));
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
		return ResponseEntity.ok(productService.addProductService(productDTO));
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts(){
		List<ProductDTO> productDTO = productService.getAllProductsService();
		return ResponseEntity.ok(productDTO);
	}
	
	@GetMapping("/getProductsByPrice")
	public ResponseEntity<List<ProductDTO>> getProductsByPrice(){
		List<ProductDTO> productDTO = productService.getAllProductsService();
		return ResponseEntity.ok(productDTO);
	}
}
