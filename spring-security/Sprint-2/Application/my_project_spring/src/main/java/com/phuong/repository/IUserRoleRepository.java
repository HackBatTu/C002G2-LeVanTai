package com.phuong.repository;

import com.phuong.model.account.AppUser;
import com.phuong.model.account.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
