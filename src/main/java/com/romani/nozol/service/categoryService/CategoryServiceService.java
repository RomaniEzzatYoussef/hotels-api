package com.romani.nozol.service.categoryService;

import com.romani.nozol.model.CategoryService;

import java.util.List;

public interface CategoryServiceService {

    List<CategoryService> getCategoryServices();

    List<CategoryService> getCategoryServicesByCategoryId(int id);

    void saveCategoryService(CategoryService categoryService);

    CategoryService getCategoryService(int id);

    void deleteCategoryService(int id);

}
