package com.shoponlineapi.controller;

import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class HistoryRestController {

    @Autowired
    private IOrderService iOrderService;

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
