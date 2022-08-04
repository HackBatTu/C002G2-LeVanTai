package com.link.service;

import com.link.model.Position;
import com.link.reponsitory.IPositionRepository;
import com.link.service.impl.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> getAllPosition() {
        return iPositionRepository.findAll();
    }
}
