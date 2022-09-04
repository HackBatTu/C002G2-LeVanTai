package com.coffee.repository;


import com.coffee.model.account.AppUser;
import com.coffee.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @param employee
     * @return true: employee, create employee success, status 200 / false: status 404
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Modifying
    @Transactional
    @Query(value = " INSERT INTO employee (name, image, phone_number, address, email, gender, birthday, salary, position_id, `user_id`) " +
            " VALUES (:#{#employee.name}, :#{#employee.image}, :#{#employee.phoneNumber}, " +
            " :#{#employee.address}, :#{#employee.email}, :#{#employee.gender}, :#{#employee.birthday}, :#{#employee.salary}, " +
            " :#{#employee.position.id} , :#{#employee.appUser.id}); ", nativeQuery = true)
    void saveEmployee(@Param("employee") Employee employee);

    /**
     * @param employee
     * @return true: employee ,edit employee success, status 200 / false: status 404
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set `name` = :#{#employee.name}, image = :#{#employee.image}," +
            " birthday = :#{#employee.birthday}, email = :#{#employee.email} , gender = :#{#employee.gender}," +
            " phone_number = :#{#employee.phoneNumber}, address = :#{#employee.address}, salary = :#{#employee.salary}" +
            " where id = :#{#employee.id} ", nativeQuery = true)
    void editEmployee(Employee employee);

    /**
     * @param id if id null : Bad request
     * @return object Employee
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address , employee.email, employee.gender, " +
            " employee.birthday, employee.salary, employee.position_id , employee.user_id, employee.is_deleted from employee " +
            " where employee.id = :id and employee.is_deleted = 0", nativeQuery = true)
    Employee findByIdEmployee(@Param("id") Integer id);



}
