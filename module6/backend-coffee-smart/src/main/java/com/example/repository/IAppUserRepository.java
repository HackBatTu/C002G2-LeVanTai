package com.example.repository;

import com.example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    @Query(value = " select app_user.id, app_user.username, app_user.password, app_user.is_deleted from app_user where is_deleted = 0 ", nativeQuery = true)
    List<AppUser> findAllUser();
}
