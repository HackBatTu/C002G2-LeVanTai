package com.shoponlineapi.repository;

import com.shoponlineapi.model.account.AppUser;
import com.shoponlineapi.model.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {

    /**
     * @param appUser
     * @return
     * @author: PhuongTD
     * @date-create 15/8/2022
     */
    @Query(value = " select ur.id, ur.is_deleted, ur.role_id, ur.user_id from user_role ur where user_id = :#{#appUser.id} ", nativeQuery = true)
    List<UserRole> findAllByAppUser(@Param("appUser") AppUser appUser);
}
