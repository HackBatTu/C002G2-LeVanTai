package com.coffee.repository;

import com.coffee.dto.IBillDto;
import com.coffee.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepository extends JpaRepository<Bill, Integer> {

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: Show bill list, with pagination,search by bill number and creation date
     *
     * @param pageable
     * @param searchCode
     * @param searchDate
     * @return
     */
    @Query(value = "select bill.id as id, bill.code as billCode, bill.creation_date as creationDate, " +
            " bill.is_deleted as isDeleted, employee.name as employeeName, coffee_table.code as coffeeTableCode, " +
            " dish_order.quantity as dishOrderQuantity, dish.name as dishName, dish.price as dishPrice, " +
            " sum(ifnull((dish.price * dish_order.quantity),0)) as totalBill " +
            " from bill " +
            " join dish_order on bill.id = dish_order.bill_id " +
            " join employee on dish_order.employee_id = employee.id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " join dish on dish_order.dish_id = dish.id " +

            " where bill.code like :searchCode and bill.creation_date like :searchDate and bill.is_deleted = 0 " +
            " group by dish_order.bill_id order by bill_id desc ", nativeQuery = true,
            countQuery = "select count(*) " +
                    " from " +
                    " (select bill.id, bill.code as billCode, bill.creation_date as creationDate, " +
                    " bill.is_deleted as isDeleted, employee.name as employeeName, coffee_table.code as coffeeTableCode, " +
                    " dish_order.quantity as dishOrderQuantity, dish.name as dishName, dish.price as dishPrice, " +
                    " sum(ifnull((dish.price * dish_order.quantity),0)) as totalBill " +
                    " from bill " +
                    " join dish_order on bill.id = dish_order.bill_id " +
                    " join employee on dish_order.employee_id = employee.id " +
                    " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
                    " join dish on dish_order.dish_id = dish.id " +
                    " where bill.code like :searchCode and bill.creation_date like :searchDate and bill.is_deleted = 0 " +
                    " group by dish_order.bill_id  order by bill_id desc ) temp_table")
    Page<IBillDto> getAllBill(Pageable pageable, @Param("searchCode") String searchCode,
                              @Param("searchDate") String searchDate);

    /**
     * Created by: HauLT
     * Date created: 09/08/2022
     * function: show bill details by id
     *
     * @param id
     * @return
     */
    @Query(value = "select bill.id as id, bill.code as billCode, bill.creation_date as creationDate, " +
            " bill.is_deleted as isDeleted, employee.name as employeeName, coffee_table.code as coffeeTableCode, " +
            " dish_order.quantity as dishOrderQuantity, dish.name as dishName, dish.price as dishPrice " +
            " from bill " +
            " join dish_order on bill.id = dish_order.bill_id " +
            " join employee on dish_order.employee_id = employee.id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " join dish on dish_order.dish_id = dish.id " +
            " where bill.id = :idDetail and bill.is_deleted = 0 ", nativeQuery = true)
    IBillDto getByIdBill(@Param("idDetail") Integer id);

    /**
     * Created by: HauLT
     * Date created: 17/08/2022
     * function: get the list of dishes
     *
     * @param id
     * @return
     */
    @Query(value = "select bill.id as id, bill.code as billCode, bill.creation_date as creationDate, " +
            " bill.is_deleted as isDeleted, employee.name as employeeName, coffee_table.code as coffeeTableCode, " +
            " sum(dish_order.quantity) as dishOrderQuantity, dish.name as dishName, dish.price as dishPrice, " +
            " sum(ifnull((dish.price * dish_order.quantity),0)) as totalBill " +
            " from bill " +
            " join dish_order on bill.id = dish_order.bill_id " +
            " join employee on dish_order.employee_id = employee.id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " join dish on dish_order.dish_id = dish.id " +
            " where dish_order.bill_id = :idDish and  bill.is_deleted = 0  group by dish_order.dish_id, dish_order.bill_id ", nativeQuery = true,
            countQuery = "select count(*) " +
                    " from " +
                    " (select bill.id, bill.code as billCode, bill.creation_date as creationDate, " +
                    " bill.is_deleted as isDeleted, employee.name as employeeName, coffee_table.code as coffeeTableCode, " +
                    " dish_order.quantity as dishOrderQuantity, dish.name as dishName, dish.price as dishPrice, " +
                    " sum(ifnull((dish.price * dish_order.quantity),0)) as totalBill " +
                    " from bill " +
                    " join dish_order on bill.id = dish_order.bill_id " +
                    " join employee on dish_order.employee_id = employee.id " +
                    " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
                    " join dish on dish_order.dish_id = dish.id " +
                    " where dish_order.bill_id = :idDish and bill.is_deleted = 0  group by dish_order.dish_id," +
                    " dish_order.bill_id) temp_table")
    List<IBillDto> getAllDish(@Param("idDish") Integer id);

    /**
     * Athor: Hoann
     * Date create: 14/08/2022
     *
     * @param code
     * @return
     */
    @Query(value = " select *  from bill where `code` = :code ", nativeQuery = true)
    Bill findByCodeBill(@Param("code") int code);

}
