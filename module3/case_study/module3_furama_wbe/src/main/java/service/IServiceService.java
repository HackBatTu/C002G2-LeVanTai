package service;

import model.RentType;
import model.Service;
import model.ServiceType;

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
