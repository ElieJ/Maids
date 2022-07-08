package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Sales;
import com.example.demo.repository.SalesRepository;
import com.example.demo.service.SalesService;
@Service
public class SalesServiceImpl implements SalesService{

    private SalesRepository salesRepository;

    

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sales saveSales(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales getSalesById(Long id) {
        return salesRepository.findById(id).get();
    }

    @Override
    public Sales updateSales(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public void deleteSalesById(Long id) {
        salesRepository.deleteById(id);
        
    }
    
}
