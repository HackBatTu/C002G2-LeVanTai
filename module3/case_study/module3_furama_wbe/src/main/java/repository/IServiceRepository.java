package repository;

import model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> selectAllService();
}
