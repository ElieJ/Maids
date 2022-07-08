package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Sales;
import com.example.demo.service.SalesService;

@Controller
public class SalesController {
    private SalesService salesService;

    
    
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales")
    public String listProducts(Model model) {
        model.addAttribute("sales",salesService.getAllSales());
        return "sales";
    }

    @GetMapping("/sales/new")
    public String createSalesForm(Model model){
        Sales sales = new Sales();
        model.addAttribute("sales",sales);
        return "create_sales";
    }

    @PostMapping("/sales")
    public String saveStudent(@ModelAttribute("sales") Sales sales){
        salesService.saveSales(sales);
        return "redirect:/sales";
    }

    @GetMapping("/sales/edit/{id}")
    public String editSalesForm(@PathVariable Long id, Model model){
        model.addAttribute("sales",salesService.getSalesById(id));
        return "edit_sales";  
    }

    @PostMapping("/sales/{id}")
    public String updateSales(@PathVariable Long id, @ModelAttribute("sales") Sales sales, Model model){
        Sales existingSales = salesService.getSalesById(id);
        existingSales.setClient(sales.getClient());
        existingSales.setSeller(sales.getSeller());
        existingSales.setTotal(sales.getTotal());

        salesService.updateSales(existingSales);
        return "redirect:/sales";
    }

    @GetMapping("/sales/{id}")
    public String deleteSales(@PathVariable Long id) {
        salesService.deleteSalesById(id);
        return "redirect:/sales";
    }
}

