package com.shoponlineapi.controller;

import com.shoponlineapi.dto.ErrorDTO;
import com.shoponlineapi.model.Customer;
import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class OrderRestController {
    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/add/cart")
    public ResponseEntity<?> addToCart(@RequestBody OrderService orderService) {
        ErrorDTO err = this.iOrderService.saveOrder(orderService);

        if (err.getMessage() != null) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(orderService ,HttpStatus.OK);
    }

    @PostMapping("/cart/minus/quantity")
    public ResponseEntity<?> minusQuantityCart(@RequestBody OrderService orderService) {
        List<OrderService> productOrderList = this.iOrderService.getProductInCardByCustomer(orderService.getCustomer());
        Boolean check = this.iOrderService.minusQuantity(orderService);
        if (check) {
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("minimum");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/cart/plus/quantity")
    public ResponseEntity<?> plusQuantityCart(@RequestBody OrderService orderService) {
        List<OrderService> productOrderList = this.iOrderService.getProductInCardByCustomer(orderService.getCustomer());
        Boolean check = this.iOrderService.plusQuantity(orderService);
        if (check) {
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("maximum");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/cart/delete")
    public ResponseEntity<?> deleteProductInCart(@RequestBody OrderService orderService) {
        Boolean check = this.iOrderService.findProductOrder(orderService);
        if (check) {
            List<OrderService> productOrderList = this.iOrderService.getProductInCardByCustomer(orderService.getCustomer());
            return new ResponseEntity<>(productOrderList, HttpStatus.OK);
        }
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setMessage("notfound");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cart/products")
    public ResponseEntity<?> getProductInCard(@RequestBody Customer customer) {
        List<OrderService> orderServiceList = this.iOrderService.getProductInCardByCustomer(customer);
        if (orderServiceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderServiceList ,HttpStatus.OK);
    }
}
