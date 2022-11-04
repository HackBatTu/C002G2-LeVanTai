package com.coffee.service.impl;


import com.coffee.model.employee.Position;
import com.coffee.repository.IPositionRepository;
import com.coffee.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
    @Override
    public List<Position> getAllPosition() {
        return iPositionRepository.findAllPosition();
    }
}
