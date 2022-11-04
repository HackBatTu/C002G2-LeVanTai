package com.coffee.repository;

import com.coffee.dto.ICoffeeTableDto;
import com.coffee.dto.ITotalPaymentDto;
import com.coffee.model.coffee_table.CoffeeTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICoffeeTableRepository extends JpaRepository<CoffeeTable, Integer> {

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param id
     * @return
     */
    @Query(value = "select dto_table.id, dto_table.name ,dto_table.price, sum(dto_table.quantity) as quantity , dto_table.code, sum(dto_table.tong_tien) " +
            " as payment, dto_table.dish_id as dishId " +
            " from (select coffee_table.id, dish.name , dish.price , dish_order.quantity , coffee_table.code," +
            " ifnull((dish.price * dish_order.quantity), 0) as tong_tien, dish.id as dish_id " +
            " from dish_order " +
            " join dish on dish.id = dish_order.dish_id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " where coffee_table.id = :idKey and dish_order.is_deleted  = 0 ) as dto_table group by(dishId) ",
            nativeQuery = true)
    List<ICoffeeTableDto> displayTableById(@Param("idKey") Integer id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE dish_order SET is_deleted = 1 WHERE ( coffee_table_id = :idKey)",
            nativeQuery = true)
    void deleteList(@Param("idKey") Integer id);

    /**
     * Create HoaNN
     * Date create 10/08/2022
     *
     * @param pageable
     * @return
     */
    @Query(value = " select id, code, status " +
            " from coffee_table ",
            countQuery = " select count(*) from " +
                    "( select id, code, status from coffee_table ) temp ",
            nativeQuery = true)
    Page<ICoffeeTableDto> displayCoffeeTableByPage(Pageable pageable);

    /**
     * Create HoaNN
     * Date create 10/08/2022
     * +
     *
     * @param id
     * @return
     */
    @Query(value = " select dto_table.id, dto_table.name,dto_table.price,dto_table.quantity,dto_table.code, dto_table.total_bill " +
            " as total " +
            " from (select coffee_table.id, dish.name , dish.price , dish_order.quantity , coffee_table.code," +
            " sum(ifnull((dish.price * dish_order.quantity),0)) as total_bill " +
            " from dish_order " +
            " join dish on dish.id = dish_order.dish_id " +
            " join coffee_table on dish_order.coffee_table_id = coffee_table.id " +
            " where coffee_table.id = :idKey2 and dish_order.is_deleted  = 0 ) as dto_table",
            nativeQuery = true)
    ITotalPaymentDto totalPayment(@Param("idKey2") Integer id);

    /**
     * Create HoaNN
     * Date create 14/08/2022
     *
     * @param idTable
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = " UPDATE `coffee_table` SET `status` = 1 WHERE (`id` = :idTable) ", nativeQuery = true)
    void updateStatus(@Param("idTable") int idTable);

    @Transactional
    @Modifying
    @Query(value = " UPDATE `coffee_table` SET `status` = 0 WHERE (`code` = :nameTable) ", nativeQuery = true)
    void updateStatusIsName(@Param("nameTable") String nameTable);

    @Query(value = " select * from `coffee_table` WHERE (`code` = :nameTable) ", nativeQuery = true)
    CoffeeTable getCodeTable(@Param("nameTable") String nameTable);
}
