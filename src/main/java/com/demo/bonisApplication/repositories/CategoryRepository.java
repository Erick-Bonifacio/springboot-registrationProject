package com.demo.bonisApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.bonisApplication.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long>{

}
