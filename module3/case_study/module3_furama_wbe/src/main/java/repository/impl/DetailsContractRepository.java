package repository.impl;

import model.*;
import repository.BaseStudentRepository;
import repository.IDetailsContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailsContractRepository implements IDetailsContractRepository {
    private BaseStudentRepository baseStudentRepository = new BaseStudentRepository();
    private static final String SELECT_DETAILS_CONTRACT = " select details_contract.*,attach_service.attach_service_name from details_contract left join contract on details_contract.contract_id=contract.contract_id left join attach_service on details_contract.attach_service_id = attach_service.attach_service_id where status=0;";



    @Override
    public List<DetailsContract> getAllDetailsContract(){
        Connection connection = baseStudentRepository.getConnection();
        List<DetailsContract> detailsContractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAILS_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("details_contract_id");
                int numberContract = resultSet.getInt("number_contract");
                int contractId = resultSet.getInt("contract_id");
                int attachServiceId = resultSet.getInt("attach_service_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                detailsContractList.add(new DetailsContract(id,numberContract,new Contract(contractId),new AttachService(attachServiceId, attachServiceName)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailsContractList;
    }
}
