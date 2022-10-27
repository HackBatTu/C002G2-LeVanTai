package shoponlineapi.controller;

import shoponlineapi.enlity.Customer;
import shoponlineapi.enlity.OrderService;
import shoponlineapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class HistoryRestController {

    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/cart/history")
    public ResponseEntity<Page<OrderService>> getOrderInCustomer(@PageableDefault(12)Pageable pageable, @RequestBody Customer customer) {
        Page<OrderService> productOrderList = this.iOrderService.getOrderInCustomer(pageable,customer);
        if (productOrderList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productOrderList, HttpStatus.OK);
    }

    @GetMapping("/list-order")
    public ResponseEntity<Page<OrderService>> getListOrder(@PageableDefault(12)Pageable pageable){
        Page<OrderService> orderServices = iOrderService.findAll(pageable);
        if(orderServices.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(orderServices, HttpStatus.OK);
    }

    @GetMapping("/yesterday")
    public ResponseEntity<Page<OrderService>> getListOrderYesterday(@PageableDefault(12)Pageable pageable){
        Page<OrderService> orderServices = iOrderService.getListOrderYesterday(pageable);
        if(orderServices.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(orderServices, HttpStatus.OK);
    }


}
