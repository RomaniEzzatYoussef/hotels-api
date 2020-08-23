package com.romani.nozol.dao.categoryType;

import com.romani.nozol.model.CategoryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryTypeDAOImpl implements CategoryTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CategoryType> getCategoryTypes() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryType> categoryTypeQuery = currentSession.createQuery("select c From CategoryType c", CategoryType.class);
        List<CategoryType> categoryTypes = categoryTypeQuery.getResultList();
        return categoryTypes;
    }

    @Override
    public void saveCategoryType(CategoryType categoryType) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(categoryType);
    }

    @Override
    public CategoryType getCategoryType(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        CategoryType categoryType = currentSession.get(CategoryType.class, id);
        return categoryType;
    }

    @Override
    public void deleteCategoryType(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from CategoryType where id=:categoryTypeId");
        query.setParameter("categoryTypeId", id);
        query.executeUpdate();
    }

}
