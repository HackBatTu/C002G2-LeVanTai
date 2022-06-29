package com.link.repository;

import com.link.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IProductRepository extends JpaRepository<Product , Integer> {
}
