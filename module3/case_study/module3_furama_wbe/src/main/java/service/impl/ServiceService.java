package service.impl;

import model.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    private IServiceRepository iServiceRepository = new ServiceRepository();

    @Override
    public List<Service> selectAllService() {
        return iServiceRepository.selectAllService();
    }
}
