package com.romani.nozol.service.categoryService;

import com.romani.nozol.dao.categoryService.CategoryServiceDAO;
import com.romani.nozol.model.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceServiceImpl implements CategoryServiceService {

    @Autowired
    private CategoryServiceDAO categoryServiceDAO;

    @Override
    @Transactional
    public List<CategoryService> getCategoryServices() {
        return categoryServiceDAO.getCategoryServices();
    }

    @Override
    @Transactional
    public List<CategoryService> getCategoryServicesByCategoryId(int id) {
        return categoryServiceDAO.getCategoryServicesByCategoryId(id);
    }

    @Override
    @Transactional
    public void saveCategoryService(CategoryService categoryService) {
        categoryServiceDAO.saveCategoryService(categoryService);
    }

    @Override
    @Transactional
    public CategoryService getCategoryService(int id) {
        return categoryServiceDAO.getCategoryService(id);
    }

    @Override
    @Transactional
    public void deleteCategoryService(int id) {
        categoryServiceDAO.deleteCategoryService(id);
    }
}





