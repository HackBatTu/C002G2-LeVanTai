package shoponlineapi.controller;

import shoponlineapi.dto.CustomerDTO;
import shoponlineapi.enlity.Customer;
import shoponlineapi.enlity.OrderService;
import shoponlineapi.repository.IOrderServiceRepository;
import shoponlineapi.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IOrderServiceRepository iOrderServiceRepository;

    @GetMapping("/customer/{userName}")
    public ResponseEntity<Customer> getCustomerByUserName(@PathVariable String userName){
        Customer customer = iCustomerService.getCustomerByUserName(userName);
        if(userName == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/customer-list")
    public ResponseEntity<Page<Customer>> getListCustomer(@PageableDefault(5) Pageable pageable){
        Page<Customer> customerPage = iCustomerService.getListCustomer(pageable);
        if(customerPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage,HttpStatus.OK);
    }

    @PostMapping("/update/customer")
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        this.iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findProductById/{id}")
    public ResponseEntity<List<OrderService>> findProduct(@PathVariable Integer id){
        List<OrderService> orderServiceList = this.iOrderServiceRepository.findProductById(id);
        if(orderServiceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderServiceList,HttpStatus.OK);
    }

}
