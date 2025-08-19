package com.example.demo.model;

public class Customer {
    private Long id;
    private String name;
    private String contact;
    private Double bill;

    public Customer(Long id, String name, String contact, Double bill) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.bill = bill;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }
}
