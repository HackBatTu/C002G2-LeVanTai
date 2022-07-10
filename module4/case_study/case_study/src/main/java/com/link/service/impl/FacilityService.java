package com.link.service.impl;

import com.link.model.customer.CustomerUsingServiceDTO;
import com.link.model.service.Facility;
import com.link.model.service.FacilityType;
import com.link.model.service.RentType;
import com.link.repository.IFacilityRepository;
import com.link.repository.IFacilityTypeRepository;
import com.link.repository.IRentTypeRepository;
import com.link.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public List<FacilityType> findAllFacilityType() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iFacilityRepository.deleteFacility(id);
    }

    @Override
    public Page<Facility> findAllFacility(String searchName, Pageable pageable) {
        return iFacilityRepository.findAllFacility("%" + searchName + "%", pageable);
    }

}
