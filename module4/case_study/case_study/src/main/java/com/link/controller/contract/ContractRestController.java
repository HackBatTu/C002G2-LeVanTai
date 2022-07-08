package com.link.controller.contract;

import com.link.model.contract.Contract;
import com.link.model.employee.Employee;
import com.link.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin
@RequestMapping("/restContract")
public class ContractRestController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("")
    public ResponseEntity<Page<Contract>> ListContract(@PageableDefault(value = 5)Pageable pageable, Optional<String> search){
        String searchDate = search.orElse("");
        Page<Contract> contractPage = iContractService.getAllContract(searchDate,pageable);
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract){
        return new ResponseEntity<>(iContractService.save(contract),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Contract> deleteContract(@PathVariable Integer id){
        Optional<Contract> contractOptional = Optional.ofNullable(iContractService.findById(id));
        iContractService.deleteContract(id);
        return new ResponseEntity<>(contractOptional.get(), HttpStatus.NO_CONTENT);
    }


}
