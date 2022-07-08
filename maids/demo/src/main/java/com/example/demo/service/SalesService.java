package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Sales;
@Service
public interface SalesService {
    List<Sales> getAllSales();
    Sales saveSales(Sales sales);
    Sales getSalesById(Long id);
    Sales updateSales(Sales sales);
    void deleteSalesById(Long id);
}
