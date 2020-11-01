package com.sudo.productapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.sudo.productapi.controller.ProductController;
import com.sudo.productapi.model.Product;

@SpringBootTest
class ProductapiApplicationTests {
	
	@Value("${productrestapi.services.url}")
	private String baseurl;

	@Autowired
	ProductController service;
	
	@Test
	void testGetOneProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseurl +"/2", Product.class);
		Assertions.assertEquals("OnePlus", product.getName());
	}
	
	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Lenovo");
		product.setDescription("This is a good phone");
		product.setPrice(15000);
		Product newProduct = restTemplate.postForObject(baseurl, product, Product.class);
		Assertions.assertEquals(product.getName(), newProduct.getName());
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setId(9);
		product.setName("Lenovo");
		product.setDescription("This is a simple phone-updated");
		product.setPrice(15000);
		Product updatedProduct = restTemplate.postForObject(baseurl, product, Product.class);
		Assertions.assertEquals(product.getName(), updatedProduct.getName());
	}
	
	@Test
	void testDeleteProduct() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(baseurl + "/9");
	}

}
