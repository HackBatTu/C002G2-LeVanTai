package com.example.repository;

import com.example.model.Employee;
import com.example.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param employee
     * if employee null : Create new employee
     * @return  employee object
     */
    @Modifying
    @Transactional
    @Query(value = " insert into employee (user_id, name, image, phone_number, address, email, gender, birthday, salary, position_id) " +
            " value (:#{#employee.user.id}, :#{#employee.name}, :#{#employee.image}, :#{#employee.phoneNumber}, " +
            " :#{#employee.address}, :#{#employee.name}, :#{#employee.gender}, :#{#employee.birthday}, :#{#employee.salary}, " +
            " :#{#employee.position.id}); ", nativeQuery = true)
    Employee saveEmployee(@Param("employee") Employee employee);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param name
     * @param image
     * @param birthday
     * @param email
     * @param gender
     * @param phoneNumber
     * @param address
     * @param salary
     * @param position
     * @return  create Employee success
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set name= ?, image = ?, birthday = ?, email = ? , gender = ?, phone_number = ?,address = ?, " +
            " salary = ?, position_id = ? " , nativeQuery = true)
    Employee editEmployee(String name, String image, Date birthday , String email, int gender, String phoneNumber, String address, Double salary, Position position);

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param id
     * if id null : Bad request
     * @return  object Employee
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address , employee.email, employee.gender, " +
            " employee.birthday, employee.salary, employee.position_id , employee.user_id, employee.is_deleted from employee " +
            " join app_user on employee.user_id = app_user.id " +
            " join `position` on employee.position_id = `position`.id " +
            " where employee.id = 1 and employee.is_deleted = 0", nativeQuery = true)
    Employee findByIdEmployee(Integer id);


}
