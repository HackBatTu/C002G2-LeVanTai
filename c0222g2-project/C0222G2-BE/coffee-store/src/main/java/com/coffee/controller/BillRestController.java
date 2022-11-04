package com.coffee.controller;

import com.coffee.dto.IBillDto;
import com.coffee.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/rest")
@RestController
@CrossOrigin
public class BillRestController {

    @Autowired
    public IBillService iBillService;

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: Show bill list, with pagination,search by bill number and creation date
     *
     * @param pageable
     * @param searchParamCode
     * @param searchParamDate
     * @return Page<Bill>
     */
    @PreAuthorize("hasAnyAuthority('ROLE_STAFF', 'ROLE_ADMIN')")
    @GetMapping("/bill")
    public ResponseEntity<Page<IBillDto>> getAllBill(@PageableDefault(10) Pageable pageable,
                                                     @RequestParam Optional<String> searchParamCode,
                                                     @RequestParam Optional<String> searchParamDate) {
        String searchCode = searchParamCode.orElse("");
        String searchDate = searchParamDate.orElse("");
        Page<IBillDto> billDtoPage = this.iBillService.getAll(pageable, searchCode, searchDate);
        if (billDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(billDtoPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: show bill details by id
     *
     * @param id
     * @return object Bill
     */
    @PreAuthorize("hasAnyAuthority('ROLE_STAFF', 'ROLE_ADMIN')")
    @GetMapping("/bill/detail/{id}")
    public ResponseEntity<IBillDto> getById(@PathVariable Integer id) {
        IBillDto iBillDto = this.iBillService.findById(id);
        if (iBillDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iBillDto, HttpStatus.OK);
    }


    /**
     * Created by: HauLT
     * Date created: 17/08/2022
     * function: get the list of dishes
     *
     * @param id
     * @return
     */

    @GetMapping("/bill/dish/{id}")
    public ResponseEntity<List<IBillDto>> getAllDish(@PathVariable Integer id){
        List<IBillDto> iBillDtoList = this.iBillService.getAllDish(id);
        if (iBillDtoList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(iBillDtoList,HttpStatus.OK);
        }
    }
}
