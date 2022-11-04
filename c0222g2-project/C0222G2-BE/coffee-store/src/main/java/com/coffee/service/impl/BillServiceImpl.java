package com.coffee.service.impl;

import com.coffee.dto.IBillDto;
import com.coffee.repository.IBillRepository;
import com.coffee.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    public IBillRepository iBillRepository;

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: Show bill list, with pagination,search by bill number and creation date
     *
     * @param pageable
     * @param searchCode
     * @param searchDate
     * @return Page<Bill>
     */
    @Override
    public Page<IBillDto> getAll(Pageable pageable, String searchCode, String searchDate) {
        return this.iBillRepository.getAllBill(pageable, "%" + searchCode + "%","%" + searchDate + "%" );
    }

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: show bill details by id
     *
     * @param id
     * @return Bill
     */
    @Override
    public IBillDto findById(Integer id) {
        return this.iBillRepository.getByIdBill(id);
    }

    /**
     * Created by: HauLT
     * Date created: 17/08/2022
     * function: get the list of dishes
     *
     * @param id
     * @return Bill
     */
    @Override
    public List<IBillDto> getAllDish(Integer id) {
        return this.iBillRepository.getAllDish(id);
    }

}
