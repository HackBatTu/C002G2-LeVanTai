package service.impl;

import model.RentType;
import model.Service;
import model.ServiceType;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
   private IServiceRepository iServiceRepository = new ServiceRepository();

   @Override
   public List<Service> getAllService() {
      return iServiceRepository.getAllService();
   }

   @Override
   public void getCreateService(Service service) {
      iServiceRepository.getCreateService(service);
   }

   @Override
   public List<RentType> getAllRentType() {
      return iServiceRepository.getAllRentType();
   }

   @Override
   public List<ServiceType> getAllServiceType() {
      return iServiceRepository.getAllServiceType();
   }

   @Override
   public void getUpdateService(Service service) {
      iServiceRepository.getUpdateService(service);
   }

   @Override
   public List<Service> findById(int idEdit) {
      return iServiceRepository.findById(idEdit);
   }

   @Override
   public void delete(int id) {
      iServiceRepository.delete(id);
   }

   @Override
   public List<Service> searchByName(String name) {
      return iServiceRepository.searchByName(name);
   }
}
