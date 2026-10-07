package com.pizzeriadonpeppe.repository;

import com.pizzeriadonpeppe.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
