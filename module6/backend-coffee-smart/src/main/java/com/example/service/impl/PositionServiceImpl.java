package com.example.service.impl;

import com.example.model.Position;
import com.example.repository.IPositionRepository;
import com.example.service.IPositionService;
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
