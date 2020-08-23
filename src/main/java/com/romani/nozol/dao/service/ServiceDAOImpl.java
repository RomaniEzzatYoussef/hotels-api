package com.romani.nozol.dao.service;

import com.romani.nozol.model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Service> getServices() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Service> serviceQuery = currentSession.createQuery("select c From Service c", Service.class);
        List<Service> services = serviceQuery.getResultList();
        return services;
    }

    @Override
    public List<Service> getServicesByCategoryServiceId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Service> serviceQuery = currentSession.createQuery("select c From Service c where c.categoryService.id = :categoryServiceId", Service.class);
        serviceQuery.setParameter("categoryServiceId", id);
        List<Service> services = serviceQuery.getResultList();
        return services;
    }

    @Override
    public void saveService(Service service) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(service);
    }

    @Override
    public Service getService(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Service service = currentSession.get(Service.class, id);
        return service;
    }

    @Override
    public void deleteService(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Service where id=:serviceId");
        query.setParameter("serviceId", id);
        query.executeUpdate();
    }

}
