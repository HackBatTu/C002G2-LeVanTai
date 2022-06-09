package repository;

import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;

import java.util.List;

public interface IServiceRepository {

    List<Service> getAllService();

    void getCreateService(Service service);

    List<ServiceType> getAllServiceType();

    List<RentType> getAllRentType();

    void getUpdateService(Service service);

    Service findById(int idEdit);

    void delete(int id);

    List<Service> searchByName(String name);
}
