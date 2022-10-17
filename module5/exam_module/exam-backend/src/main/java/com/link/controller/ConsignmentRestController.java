package com.link.controller;

import com.link.dto.ConsignmentDTO;
import com.link.model.Consignment;
import com.link.model.Product;
import com.link.service.IConsignmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ConsignmentRestController {

    @Autowired
    private IConsignmentService iConsignmentService;

    @GetMapping("/consignment")
    public ResponseEntity<Page<Consignment>> getAllConsignment(@PageableDefault(5)Pageable pageable,
                                                               Optional<String> searchName,
                                                               Optional<String> searchDateCheckOut,

                                                               Optional<String> searchStartDate,
                                                               Optional<String> searchEndDate){
        String productName = searchName.orElse("");
        String dateCheckOut = searchDateCheckOut.orElse("");
        String startDate = searchStartDate.orElse("1000-01-01");
        String endDate = searchEndDate.orElse("3000-01-01");

        Page<Consignment> consignmentPage = iConsignmentService.findAllConsignment(pageable,productName,dateCheckOut,startDate,endDate);
        if(consignmentPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(consignmentPage,HttpStatus.OK);
        }

    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = this.iConsignmentService.findAllProduct();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Consignment> createConsignment(@Valid @RequestBody ConsignmentDTO consignmentDTO) {
        Consignment consignment = new Consignment();
        BeanUtils.copyProperties(consignmentDTO,consignment);
        return new ResponseEntity<>(iConsignmentService.save(consignment),HttpStatus.CREATED);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Consignment> findByID(@PathVariable Integer id) {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Consignment> consignmentOptional = Optional.ofNullable(iConsignmentService.findById(id));
        return new ResponseEntity<>(consignmentOptional.get(), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Consignment> updateConsignment(@Valid @RequestBody ConsignmentDTO consignmentDTO,@PathVariable Integer id) {
        Optional<Consignment> consignmentOptional = Optional.ofNullable(iConsignmentService.findById(id));
        Consignment consignment = new Consignment();
        BeanUtils.copyProperties(consignmentDTO,consignment);
        consignment.setId(consignmentOptional.get().getId());
        return new ResponseEntity<>(iConsignmentService.save(consignment),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConsignment(@PathVariable Integer id) {
        this.iConsignmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
