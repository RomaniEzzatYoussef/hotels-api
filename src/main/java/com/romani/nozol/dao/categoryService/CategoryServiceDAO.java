package com.romani.nozol.dao.categoryService;

import com.romani.nozol.model.CategoryService;

import java.util.List;

public interface CategoryServiceDAO {

    List<CategoryService> getCategoryServices();

    List<CategoryService> getCategoryServicesByCategoryId(int id);

    void saveCategoryService(CategoryService categoryService);

    CategoryService getCategoryService(int id);

    void deleteCategoryService(int id);
}
