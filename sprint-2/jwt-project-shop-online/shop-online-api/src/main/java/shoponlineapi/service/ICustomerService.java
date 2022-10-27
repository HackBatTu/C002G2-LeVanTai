package shoponlineapi.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import shoponlineapi.enlity.Customer;

public interface ICustomerService {
    Customer getCustomerByUserName(String userName);

    void save(Customer customer);


    Page<Customer> getListCustomer(Pageable pageable);


}
