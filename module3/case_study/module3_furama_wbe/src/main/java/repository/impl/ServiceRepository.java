package repository.impl;

import model.*;
import repository.BaseStudentRepository;
import repository.IServiceRepository;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private static BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_SERVICE = " select service.*,rent_type.rent_type_name,service_type.service_type_name from service " +
            " left join rent_type on service.rent_type_id=rent_type.rent_type_id left join service_type on service.service_type_id=service_type.service_type_id where service.status = 0; ";
    private static final String INSERT_INTO = " insert into service(service_id,service_name,service_area,service_cost,service_max_person,room_standard,another_convenient,pool_area,number_of_floors,service.rent_type_id,service.service_type_id) value (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_RENT_TYPE = " select * from rent_type where status = 0;";
    private static final String SELECT_SERVICE_TYPE = " select * from service_type where status = 0;";
    private static final String UPDATE_SERVICE = " update service set service_name=?,service_area=?,service_cost=?,service_max_person=?,room_standard=?,another_convenient=?,pool_area=?,number_of_floors=?,service.rent_type_id=?,service.service_type_id=? where service_id =?;";
    private static final String SELECT_SERVICE_BY_ID = " select * from service where service_id = ? ;";
    private static final String DELETE_SERVICE = " update service set status = 1 where service_id=?;";
    private static final String SEARCH_BY_NAME= " select service.*,rent_type.rent_type_name,service_type.service_type_name from service " +
            " left join rent_type on service.rent_type_id=rent_type.rent_type_id left join service_type on service.service_type_id=service_type.service_type_id where service.service_name like ? ;";


    @Override
    public List<Service> getAllService() {

        Connection connection = baseStudentRepository.getConnection();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxPerson = resultSet.getInt("service_max_person");
                String roomStandard = resultSet.getString("room_standard");
                String anotherConvenient = resultSet.getString("another_convenient");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                int serviceType = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceList.add(new Service(id, name, area, cost, maxPerson, roomStandard, anotherConvenient, poolArea, numberOfFloors, new RentType(rentType, rentTypeName), new ServiceType(serviceType, serviceTypeName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void getCreateService(Service service) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getMaxPerson());
            preparedStatement.setString(6, service.getRoomStandard());
            preparedStatement.setString(7, service.getAnotherConvenient());
            preparedStatement.setDouble(8, service.getPoolArea());
            preparedStatement.setInt(9, service.getNumOfFloors());
            preparedStatement.setInt(10, service.getRentType().getId());
            preparedStatement.setInt(11, service.getServiceType().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ServiceType> getAllServiceType() {
        Connection connection = baseStudentRepository.getConnection();
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                int status = resultSet.getInt("status");
                serviceTypeList.add(new ServiceType(id, name, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }

    @Override
    public List<RentType> getAllRentType() {
        Connection connection = baseStudentRepository.getConnection();
        List<RentType> rentTypeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                int status = resultSet.getInt("status");
                rentTypeList.add(new RentType(id, name, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypeList;
    }

    @Override
    public void getUpdateService(Service service) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPerson());
            preparedStatement.setString(5, service.getRoomStandard());
            preparedStatement.setString(6, service.getAnotherConvenient());
            preparedStatement.setDouble(7, service.getPoolArea());
            preparedStatement.setInt(8, service.getNumOfFloors());
            preparedStatement.setInt(9, service.getRentType().getId());
            preparedStatement.setInt(10, service.getServiceType().getId());
            preparedStatement.setInt(11, service.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> findById(int idEdit) {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, idEdit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxPerson = resultSet.getInt("service_max_person");
                String roomStandard = resultSet.getString("room_standard");
                String anotherConvenient = resultSet.getString("another_convenient");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                int serviceType = resultSet.getInt("service_type_id");
                serviceList.add(new Service(id, name, area, cost, maxPerson, roomStandard, anotherConvenient, poolArea, numberOfFloors, new RentType(rentType), new ServiceType(serviceType)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }


    @Override
    public List<Service> searchByName(String name) {
        Connection connection = baseStudentRepository.getConnection();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("service_id");
                String names = resultSet.getString("service_name");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxPerson = resultSet.getInt("service_max_person");
                String roomStandard = resultSet.getString("room_standard");
                String anotherConvenient = resultSet.getString("another_convenient");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                int serviceType = resultSet.getInt("service_type_id");
                String serviceTypeName= resultSet.getString("service_type_name");
                serviceList.add(new Service(id,names,area,cost,maxPerson,roomStandard,anotherConvenient,poolArea,numberOfFloors,new RentType(rentType,rentTypeName),new ServiceType(serviceType,serviceTypeName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public void delete(int id) {
        Connection connection = baseStudentRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SERVICE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
