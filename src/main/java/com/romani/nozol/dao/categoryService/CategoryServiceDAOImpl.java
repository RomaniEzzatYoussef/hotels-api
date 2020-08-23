package com.romani.nozol.dao.categoryService;

import com.romani.nozol.model.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryServiceDAOImpl implements CategoryServiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CategoryService> getCategoryServices() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryService> categoryServiceQuery = currentSession.createQuery("select c From CategoryService c", CategoryService.class);
        List<CategoryService> categoryServices = categoryServiceQuery.getResultList();
        return categoryServices;
    }

    @Override
    public List<CategoryService> getCategoryServicesByCategoryId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<CategoryService> categoryServiceQuery = currentSession.createQuery("select c From CategoryService c where c.category.id=:categoryId", CategoryService.class);
        categoryServiceQuery.setParameter("categoryId" , id);
        List<CategoryService> categoryServices = categoryServiceQuery.getResultList();
        return categoryServices;
    }

    @Override
    public void saveCategoryService(CategoryService categoryService) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(categoryService);
    }

    @Override
    public CategoryService getCategoryService(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        CategoryService categoryService = currentSession.get(CategoryService.class, id);
        return categoryService;
    }

    @Override
    public void deleteCategoryService(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from CategoryService where id=:categoryServiceId");
        query.setParameter("categoryServiceId", id);
        query.executeUpdate();
    }

}
