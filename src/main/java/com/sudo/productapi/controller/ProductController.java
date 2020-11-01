package com.sudo.productapi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sudo.productapi.model.Product;
import com.sudo.productapi.repository.ProductRepository;

@RestController
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository repo;
	
	@RequestMapping(value = "/products", method=RequestMethod.GET)
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/product/{id}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable ("id") int id ) {
		LOGGER.info("FINDING PRODUCT ID: "+id);
		return repo.findById(id).get();
	}
	
	@RequestMapping(value = "/product", method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@RequestMapping(value = "/product", method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@RequestMapping(value = "/product/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable ("id") int id ) {
		repo.deleteById(id);
	}
	
}

