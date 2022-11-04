package com.coffee.repository;

import com.coffee.dto.DishMostOrderDTO;
import com.coffee.dto.DishNewestDTO;
import com.coffee.model.dish_order.DishOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.coffee.model.bill.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IDishOrderRepository extends JpaRepository<DishOrder, Integer> {

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish most order in database
     */
    @Query(value = " SELECT dishId, name, price, image, time_order as timeOrder " +
            " FROM (SELECT dish_order.dish_id as dishId, dish.name as name, dish.price as price," +
            " dish.image as image, sum(quantity) as time_order " +
            " FROM dish_order inner join dish on dish_order.dish_id = dish.id " +
            " GROUP BY  dish_order.dish_id ORDER BY time_order DESC LIMIT 5) as dto_table"
            , nativeQuery = true)
    List<DishMostOrderDTO> get5DishMostOrderDTO();

    /**
     * Created by: BaoTQ
     * Date create: 09/08/2022
     * function: get 5 dish newest in database
     */
    @Query(value = " SELECT id,name,creation_date as dateCreate,price,image " +
            " FROM dish ORDER BY creation_date DESC LIMIT 5", nativeQuery = true)
    List<DishNewestDTO> get5DishNewestDTO();

    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function will return all data can get below database use native query
     * .@param pageable, @return
     **/
    @Query(value = " select id, coffee_table_id, `code`, quantity, dish_id, bill_id, " +
            " employee_id, is_deleted from dish_order where is_deleted = 0",countQuery = "select count(*) from" +
            " ( select id, coffee_table_id, `code`, quantity, dish_id, bill_id, employee_id, is_deleted " +
            " from dish_order where is_deleted = 0 ) as dishOrder",
            nativeQuery = true)
    Page<DishOrder> getAllOrder(Pageable pageable);

    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function create order menu and insert into database, use native query
     * .@param is object, @return
     **/
    @Transactional
    @Modifying
    @Query(value = "insert into dish_order(coffee_table_id, code, quantity, dish_id, bill_id, employee_id)" +
            "values (:#{#dishOrder.coffeeTable.id}, :#{#dishOrder.code}, :#{#dishOrder.quantity}, " +
            ":#{#dishOrder.dish.id}, :#{#dishOrder.bill.id}, :#{#dishOrder.employee.id})", nativeQuery = true)
    void createOrder(DishOrder dishOrder);


    /**
     * Author: BinhPX
     * Date created: 09/08/2022
     * This function find any order have table id match param.
     * .@param table id, @return
     **/
    @Query(value="select dor.id, dor.dish_id, dor.coffee_table_id, sum(dor.quantity) as quantity, dor.code, dor.employee_id, dor.bill_id, " +
            " dor.is_deleted from dish_order dor \n" +
            "inner join coffee_table on coffee_table.id = dor.coffee_table_id\n" +
            "where coffee_table.id = :param and dor.is_deleted = 0\n" +
            "group by dor.dish_id", nativeQuery = true)
    List<DishOrder> getOrderHaveCode(@Param("param") int param);

     /**
     *   Author: BinhPX
     *   Date created: 12/08/2022
     *   This function delete order have code order match param.
     *   .@param table id, @return
     **/
    @Transactional
    @Modifying
    @Query(value = "update dish_order set is_deleted = 1 where code = :code", nativeQuery = true)
    void deleteOrder(@Param("code") String code);

    /**
     * @param billAfter
     * @param idTable
     * @author HoaNN
     */
    @Transactional
    @Modifying
    @Query(value = " UPDATE `dish_order` SET `bill_id` = :#{#billAfter.id} WHERE (`coffee_table_id` = :idTable) ", nativeQuery = true)
    void updateBill(Bill billAfter, @Param("idTable") int idTable);
}
