package com.link.service;

import com.link.model.service.Facility;
import com.link.model.service.FacilityType;
import com.link.model.service.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    List<FacilityType> findAllFacilityType();

    List<RentType> findAllRentType();

    void save(Facility facility);

    Facility findById(Integer id);

    void delete(Integer id);

    Page<Facility> findAllFacility(String searchName, Pageable pageable);

}
