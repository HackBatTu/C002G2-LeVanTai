package com.link.repository;

import com.link.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface  AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String userName);

}
