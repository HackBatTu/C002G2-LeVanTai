package com.link.repository;

import com.link.model.Employee;
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
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query(value = "select * from employee where status = 0 and name like :searchName", nativeQuery = true,
    countQuery = "select count(*) form (select * from employee where status = 0 and name like :searchName ) temp_table")
    Page<Employee> findAllEmployee(@Param("searchName") String searchName, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update employee e set status = 1 where e.id = :id",nativeQuery = true)
    void deleteEmployee(Integer id);

    @Query(value = "select * from employee where status = 0", nativeQuery = true)
    List<Employee> getAllEmployee();
}
