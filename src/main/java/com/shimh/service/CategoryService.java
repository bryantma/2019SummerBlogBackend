package com.shimh.service;

import com.shimh.entity.Category;
import com.shimh.vo.CategoryVO;

import java.util.List;


public interface CategoryService {

    List<Category> findAll();

    Category getCategoryById(Integer id);

    Integer saveCategory(Category category);

    Integer updateCategory(Category category);

    void deleteCategoryById(Integer id);

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
