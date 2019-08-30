package com.shimh.repository.wrapper;

import com.shimh.vo.CategoryVO;

import java.util.List;


public interface CategoryWrapper {

    List<CategoryVO> findAllDetail();

    CategoryVO getCategoryDetail(Integer categoryId);
}
