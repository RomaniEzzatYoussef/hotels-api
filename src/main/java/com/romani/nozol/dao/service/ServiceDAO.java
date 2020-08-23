package com.romani.nozol.dao.service;

import com.romani.nozol.model.Service;
import java.util.List;

public interface ServiceDAO {

    List<Service> getServices();

    List<Service> getServicesByCategoryServiceId(int id);

    void saveService(Service service);

    Service getService(int id);

    void deleteService(int id);
}
