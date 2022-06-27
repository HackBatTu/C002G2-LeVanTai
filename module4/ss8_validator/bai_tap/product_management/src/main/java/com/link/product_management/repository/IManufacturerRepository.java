package com.link.product_management.repository;

import com.link.product_management.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
}
