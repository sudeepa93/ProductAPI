package com.sudo.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudo.productapi.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
