package com.link.repository;

import com.link.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {


    @Modifying
    @Transactional
    @Query(value = "update facility f set status = 1 where f.id = :id ", nativeQuery = true)
    void deleteFacility(Integer id);


    @Query(value = "select * from facility where status = 0 and name like :searchName" , nativeQuery = true,
    countQuery = " select count(*) from (select * from facility where status = 0 and name like :searchName) temp_table")
    Page<Facility> findAllFacility(@Param("searchName") String searchName, Pageable pageable);

    @Query(value = "select * from facility where status = 0 ", nativeQuery = true)
    List<Facility> getAllFacility();
}
