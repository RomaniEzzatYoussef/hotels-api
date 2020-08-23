package com.romani.nozol.service.categoryType;

import com.romani.nozol.model.CategoryType;
import java.util.List;

public interface CategoryTypeService {

    List<CategoryType> getCategoryTypes();

    void saveCategoryType(CategoryType categoryType);

    CategoryType getCategoryType(int id);

    void deleteCategoryType(int id);

}
