package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "seller")
    private String seller;

    @Column(name = "date")
    private String date;

    @Column(name = "total")
    private String total;

    
    
    public Sales() {
    }

    

    public Sales(String client, String seller, String creationDate, String total, String date) {
        this.client = client;
        this.seller = seller;
        this.date = date;
        this.total = total;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getClient() {
        return client;
    }



    public void setClient(String client) {
        this.client = client;
    }



    public String getSeller() {
        return seller;
    }



    public void setSeller(String seller) {
        this.seller = seller;
    }



    public String getDate() {
        return date;
    }



    public void setDate(String date) {
        this.date = date;
    }



    public String getTotal() {
        return total;
    }



    public void setTotal(String total) {
        this.total = total;
    }



    



    

    

}