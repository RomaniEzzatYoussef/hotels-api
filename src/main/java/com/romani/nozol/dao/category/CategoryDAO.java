package com.romani.nozol.dao.category;

import com.romani.nozol.model.Category;
import java.util.List;

public interface CategoryDAO {

    List<Category> getCategories();

    List<Category> getCategoriesByCategoryType(int id);

    void saveCategory(Category category);

    Category getCategory(int id);

    void deleteCategory(int id);
}
