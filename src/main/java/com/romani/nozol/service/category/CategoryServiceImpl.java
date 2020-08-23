package com.romani.nozol.service.category;

import com.romani.nozol.dao.category.CategoryDAO;
import com.romani.nozol.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    @Transactional
    public List<Category> getCategoriesByCategoryType(int id) {
        return categoryDAO.getCategoriesByCategoryType(id);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}

