package com.coffee.service.impl;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.model.coffee_table.CoffeeTable;
import com.coffee.repository.ICoffeeTableRepository;
import com.coffee.service.ICoffeeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeTableService implements ICoffeeTableService {

    @Autowired
    private ICoffeeTableRepository iCoffeeTableRepository;

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param id
     * @return
     */
    @Override
    public List<ICoffeeTableDto> findByIdTable(Integer id) {
        return this.iCoffeeTableRepository.displayTableById(id);
    }

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable) {
        return this.iCoffeeTableRepository.displayCoffeeTableByPage(pageable);
    }

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param id
     * @return
     */
    @Override
    public ITotalPaymentDto calcultion(Integer id) {
        return this.iCoffeeTableRepository.totalPayment(id);
    }

    @Override
    public void updateStatus(int idTable) {
        this.iCoffeeTableRepository.updateStatus(idTable);
    }

    @Override
    public void deleteList(Integer id) {
        this.iCoffeeTableRepository.deleteList(id);
    }

    @Override
    public CoffeeTable getTableCode(String nameTable) {
        return this.iCoffeeTableRepository.getCodeTable(nameTable);
    }

    @Override
    public void updateStatusIsName(String nameTable) {
        this.iCoffeeTableRepository.updateStatusIsName(nameTable);
    }
}
