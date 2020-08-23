package com.romani.nozol.service.service;

import com.romani.nozol.dao.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceDAO serviceDAO;

    @Override
    @Transactional
    public List<com.romani.nozol.model.Service> getServices() {
        return serviceDAO.getServices();
    }

    @Override
    @Transactional
    public List<com.romani.nozol.model.Service> getServicesByCategoryServiceId(int id) {
        return serviceDAO.getServicesByCategoryServiceId(id);
    }

    @Override
    @Transactional
    public void saveService(com.romani.nozol.model.Service service) {
        serviceDAO.saveService(service);
    }

    @Override
    @Transactional
    public com.romani.nozol.model.Service getService(int id) {
        return serviceDAO.getService(id);
    }

    @Override
    @Transactional
    public void deleteService(int id) {
        serviceDAO.deleteService(id);
    }
}





