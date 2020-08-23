package com.romani.nozol.service.service;

import com.romani.nozol.model.Service;
import java.util.List;


public interface ServiceService {

    List<Service> getServices();

    List<Service> getServicesByCategoryServiceId(int id);

    void saveService(Service service);

    Service getService(int id);

    void deleteService(int id);

}
