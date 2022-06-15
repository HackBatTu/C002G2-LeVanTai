package service.impl;

import common.Validate;
import model.CustomerServiceDTO;
import model.person.Customer;
import model.person.CustomerType;
import repository.impl.CustomerRepository;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

public class CustomerService implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");



    @Override
    public List<Customer> selectAll() {
        return iCustomerRepository.selectAll();
    }

    @Override
    public Map<String, String> add(Customer customerList) {
        Map<String, String> errors = new HashMap<>();

        List<CustomerType> customerTypes = iCustomerRepository.getAllCustomerType();
        boolean flag = false;
        for (CustomerType customerType : customerTypes) {
            if (customerList.getCustomerType().getId() == customerType.getId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errors.put("CustomerType", "xl đi b ơi ! đừng f12!");
        }
        if(customerList.getName().equals("")||customerList.getName()== null){
            errors.put("name","name is not null");
        }
        if (Validate.regexDate(customerList.getBirthDay()) || customerList.getBirthDay().equals("")) {
            errors.put("birthDay", "Nhập dữ liệu đi bạn!");
        } else {
            try {
                customerList.setBirthDay(simpleDateFormat.format(simpleDateFormat.parse(customerList.getBirthDay())));
            } catch (ParseException e) {
                errors.put("birthDay", "xl bạn ơi! đừng f12!");
            }
        }
        if (customerList.getGender() < 0 || customerList.getGender() > 2) {
            errors.put("gender", "bạn ơi nhập từ 0 đến 2 thôi!");
        }
        if(Validate.regexIdCard(customerList.getIdCard())|| customerList.getIdCard().equals("")){
            errors.put("idCard","idCard invalid");
        }
        if(Validate.regexPhone(customerList.getPhone())|| customerList.getPhone().equals("")){
            errors.put("phone","phone invalid");
        }
        if(Validate.regexEmail(customerList.getEmail())|| customerList.getEmail().equals("")){
            errors.put("email","email invalid");
        }
        if(customerList.getAddress().equals("")){
            errors.put("address","address is not null");
        }
        if(errors.isEmpty()){
            iCustomerRepository.add(customerList);
        }else {
            return errors;
        }

        return errors;
    }

    @Override
    public Map<String, String> update(Customer customerList) {
        Map<String, String> errors = new HashMap<>();
        List<CustomerType> customerTypes = iCustomerRepository.getAllCustomerType();
        boolean flag = false;
        for (CustomerType customerType : customerTypes) {
            if (customerList.getCustomerType().getId() == customerType.getId()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            errors.put("CustomerType", "xl đi b ơi ! đừng f12!");
        }
        if(customerList.getName().equals("")||customerList.getName()== null){
            errors.put("name","name is not null");
        }
        if (Validate.regexDate(customerList.getBirthDay()) || customerList.getBirthDay().equals("")) {
            errors.put("birthDay", "bạn mới chơi đồ ak, coi lại ngày tháng hiện tại mà nhập b ơi!");
        } else {
            try {
                customerList.setBirthDay(simpleDateFormat.format(simpleDateFormat.parse(customerList.getBirthDay())));
            } catch (ParseException e) {
                errors.put("birthDay", "xl bạn ơi! đừng f12!");
            }
        }
        if (customerList.getGender() < 0 || customerList.getGender() > 2) {
            errors.put("gender", "bạn ơi nhập từ 0 đến 2 thôi!");
        }
        if(Validate.regexIdCard(customerList.getIdCard())|| customerList.getIdCard().equals("")){
            errors.put("idCard","idCard invalid");
        }
        if(Validate.regexPhone(customerList.getPhone())|| customerList.getPhone().equals("")){
            errors.put("phone","phone invalid");
        }
        if(Validate.regexEmail(customerList.getEmail())|| customerList.getEmail().equals("")){
            errors.put("email","email invalid");
        }
        if(customerList.getAddress().equals("")){
            errors.put("address","address is not null");
        }
        if(errors.isEmpty()){
            iCustomerRepository.update(customerList);
        }else {
            return errors;
        }

        return errors;
    }

    @Override
    public void delete(int id) {
        iCustomerRepository.delete(id);
    }

    @Override
    public List<Customer> searchByName(String name, String customerType) {
        return iCustomerRepository.searchByName(name,customerType);
    }

    @Override
    public List<Customer> sortByName() {
        return iCustomerRepository.sortByName();
    }

    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerRepository.getAllCustomerType();

    }

    @Override
    public List<CustomerServiceDTO> getAllCustomerServiceDTO() {
        return iCustomerRepository.getAllCustomerServiceDTO();
    }
}
