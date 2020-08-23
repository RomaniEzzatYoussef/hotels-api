package com.romani.nozol.dao.category;

import com.romani.nozol.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> categoryQuery = currentSession.createQuery("select c From Category c", Category.class);

        List<Category> categories = categoryQuery.getResultList();

        return categories;
    }

    @Override
    public List<Category> getCategoriesByCategoryType(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Category> categoryQuery = currentSession.createQuery("select c From Category c where c.categoryType.id = :categoryTypeId", Category.class);
        categoryQuery.setParameter("categoryTypeId" , id);

        List<Category> categories = categoryQuery.getResultList();

        return categories;
    }

    @Override
    public void saveCategory(Category category) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(category);
    }

    @Override
    public Category getCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Category category = currentSession.get(Category.class, id);
        return category;
    }

    @Override
    public void deleteCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Category where id=:categoryId");
        query.setParameter("categoryId", id);
        query.executeUpdate();
    }

}
