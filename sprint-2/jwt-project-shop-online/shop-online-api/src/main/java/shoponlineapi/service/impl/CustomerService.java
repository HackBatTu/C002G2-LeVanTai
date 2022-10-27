package shoponlineapi.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shoponlineapi.enlity.Customer;
import shoponlineapi.repository.ICustomerRepository;
import shoponlineapi.service.ICustomerService;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Customer getCustomerByUserName(String userName) {
        return iCustomerRepository.getCustomerByUserName(userName);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> getListCustomer(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }


}
