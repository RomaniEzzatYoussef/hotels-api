package com.romani.nozol.service.categoryType;

import com.romani.nozol.dao.categoryType.CategoryTypeDAO;
import com.romani.nozol.model.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    private CategoryTypeDAO categoryTypeDAO;

    @Override
    @Transactional
    public List<CategoryType> getCategoryTypes() {
        return categoryTypeDAO.getCategoryTypes();
    }

    @Override
    @Transactional
    public void saveCategoryType(CategoryType categoryType) {
        categoryTypeDAO.saveCategoryType(categoryType);
    }

    @Override
    @Transactional
    public CategoryType getCategoryType(int id) {
        return categoryTypeDAO.getCategoryType(id);
    }

    @Override
    @Transactional
    public void deleteCategoryType(int id) {
        categoryTypeDAO.deleteCategoryType(id);
    }
}





