package repository;

import model.RentType;
import model.Service;
import model.ServiceType;

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
