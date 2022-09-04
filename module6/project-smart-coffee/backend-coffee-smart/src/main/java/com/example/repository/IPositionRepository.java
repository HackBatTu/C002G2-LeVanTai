package com.example.repository;

import com.example.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  Position list
     */
    @Query(value = " select `position`.id, `position`.name, `position`.is_deleted from `position` where `position`.is_deleted = 0 ", nativeQuery = true)
    List<Position> findAllPosition();
}
