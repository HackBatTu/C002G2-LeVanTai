package com.phuong.repository;

import com.phuong.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = " select au.id, au.is_deleted, " +
            " au.password, au.user_name, au.status from app_user au where au.user_name = :username and au.is_deleted = 0 ",
            nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query(value = " update app_user au set au.status = 1 where au.id = :id ", nativeQuery = true)
    void updateStatus(@Param("id") Integer id);
}
