package service;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;

import java.util.List;

public interface IServiceService {

    List<Service> getAllService();

    void getCreateService(Service service);

    List<RentType> getAllRentType();

    List<ServiceType> getAllServiceType();

    void getUpdateService(Service service);

    Service findById(int idEdit);

    void delete(int id);

    List<Service> searchByName(String name);
}
