package com.link.booklibrary.repository;

import com.link.booklibrary.model.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrafficRepository extends JpaRepository<Traffic, Integer> {
}
