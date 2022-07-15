package com.link.repository;

import com.link.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<Room, String> {

    @Query(value = "select * from room where status = 0", nativeQuery = true)
    List<Room> findAllRoom();
}
