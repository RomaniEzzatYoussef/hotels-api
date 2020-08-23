package com.romani.nozol.dao.categoryType;

import com.romani.nozol.model.CategoryType;

import java.util.List;

public interface CategoryTypeDAO {

    List<CategoryType> getCategoryTypes();

    void saveCategoryType(CategoryType categoryType);

    CategoryType getCategoryType(int id);

    void deleteCategoryType(int id);
}
