package com.coffee.repository;


import com.coffee.dto.IEmployeeDTO;
import com.coffee.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     * method show list and search and paging
     * tuyentn-list-employee-2
     *
     * @param pageable
     * @param searchByName
     * @param searchByPhone
     * @param searchByAccount
     * @return
     */
    @Query(value = " select e.`name` as name,e.phone_number as phoneNumber,`position`.name as `position`, " +
            " app_user.user_name as appUser,e.id,e.birthday,e.image,e.address,e.salary, " +
            " e.gender,e.email from employee e " +
            " join app_user on app_user.id = e.user_id " +
            " join `position` on e.position_id = `position`.id " +
            " where e.is_deleted =0 and e.name like :keyZero and e.phone_number like :keyOne " +
            " and app_user.user_name like :keyTwo ",
            countQuery = " select count(*) from (select e.`name` as name,e.phone_number as phoneNumber, " +
                    " app_user.user_name as appUser,`position`.name as `position`,e.id,e.birthday,e.image, " +
                    " e.address,e.salary, e.gender,e.email from employee e " +
                    " join app_user on app_user.id = e.user_id " +
                    " join `position` on e.position_id = `position`.id " +
                    " where e.is_deleted =0 and e.name like :keyZero and e.phone_number like :keyOne " +
                    " and app_user.user_name like :keyTwo ) templol ", nativeQuery = true)
    Page<IEmployeeDTO> getAllEmployee(Pageable pageable, @Param("keyZero") String searchByName,
                                      @Param("keyOne") String searchByPhone,
                                      @Param("keyTwo") String searchByAccount);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     *
     * @param id
     * @return
     */
    @Query(value = "select employee.`name`,employee.phone_number as phoneNumber,position.name as position, " +
            " app_user.user_name as appUser,employee.id,employee.birthday,employee.image,employee.address,employee.salary, " +
            " employee.gender,employee.email from employee " +
            " join app_user on app_user.id = employee.user_id " +
            " join position on employee.position_id = position.id " +
            " where employee.is_deleted =0 and employee.id = :id ", nativeQuery = true)
    IEmployeeDTO findEmployeeById(Integer id);

    /**
     * Create by TuyenTN
     * Date: 16:30 pm  9-8-2022
     *
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = " update employee set is_deleted = 1 where id = :id ", nativeQuery = true)
    void deleteEmployeeById(Integer id);


    /**
     * end code TuyenTN
     */

//-------------------------------------------------------------------------------------------------------------------
    /**
     * start code TaiLV
     */

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
            " phone_number = :#{#employee.phoneNumber}, address = :#{#employee.address}, salary = :#{#employee.salary} ," +
            " user_id =:#{#employee.appUser.id} , position_id = :#{#employee.position.id}" +
            " where id = :#{#employee.id} ", nativeQuery = true)
    void editEmployee(Employee employee);

    /**
     * @param id if id null : Bad request
     * @return object Employee
     * @creator TaiLV
     * Date 09/08/2022
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address ," +
            " employee.email, employee.gender, " +
            " employee.birthday, employee.salary, employee.position_id , employee.user_id, employee.is_deleted from employee " +
            " where employee.id = :id and employee.is_deleted = 0", nativeQuery = true)
    Employee findByIdEmployee(@Param("id") Integer id);

    /**
     * @return list Employee
     * @creator TaiLV
     * Date 13/08/2022
     */
    @Query(value = " select employee.id, employee.name, employee.image,employee.phone_number , employee.address, " +
            " employee.email, employee.gender, employee.birthday, employee.salary, employee.position_id , " +
            " employee.user_id, employee.is_deleted from employee where employee.is_deleted = 0 ", nativeQuery = true)
    List<Employee> findAllEmployee();

}
