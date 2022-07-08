package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Sales;
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long>{
    
}
