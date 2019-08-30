package com.shimh.repository;

import com.shimh.entity.Category;
import com.shimh.repository.wrapper.CategoryWrapper;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer>, CategoryWrapper {
}
