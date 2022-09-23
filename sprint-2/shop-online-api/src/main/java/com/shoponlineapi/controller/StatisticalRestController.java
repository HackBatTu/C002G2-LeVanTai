package com.shoponlineapi.controller;

import com.shoponlineapi.dto.CustomerTopDTO;
import com.shoponlineapi.dto.StatisticDTO;
import com.shoponlineapi.model.OrderService;
import com.shoponlineapi.repository.IOrderServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class StatisticalRestController {
    @Autowired
    private IOrderServiceRepository iOrderServiceRepository;

    @GetMapping("/statistic/by-week")
    public ResponseEntity<List<StatisticDTO>> getWeekStatistic(){
        List<StatisticDTO> orderServiceList = iOrderServiceRepository.getWeekStatistic();
        if(orderServiceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderServiceList,HttpStatus.OK);
    }
    @GetMapping("/statistic/by-month")
    public ResponseEntity<List<StatisticDTO>> getMonthStatistic(){
        List<StatisticDTO> orderServiceList = iOrderServiceRepository.getMonthStatistic();
        if(orderServiceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderServiceList,HttpStatus.OK);
    }
    @GetMapping("/statistic/by-year")
    public ResponseEntity<List<StatisticDTO>> getYearStatistic(){
        List<StatisticDTO> orderServiceList = iOrderServiceRepository.getYearStatistic();
        if(orderServiceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderServiceList,HttpStatus.OK);
    }
    @GetMapping("/customer-top")
    public ResponseEntity<List<CustomerTopDTO>> getTopCustomer(){
        List<CustomerTopDTO> customerTopDTOList = iOrderServiceRepository.getTopCustomer();
        if(customerTopDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTopDTOList,HttpStatus.OK);
    }
}
