package com.pizzeriadonpeppe.repository;

import com.pizzeriadonpeppe.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
