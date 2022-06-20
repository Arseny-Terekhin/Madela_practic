package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OrganizationEntity;

public class Organization {
    private Long id;
    private String name;
    private String fullName;
    private String inn;
    private String kpp;
    private String address;
    private String phone;
    private Boolean isActive;

    public static Organization toModel(OrganizationEntity entity){
        Organization org = new Organization();
        org.setId(entity.getId());
        org.setName(entity.getName());
        org.setFullName(entity.getFullName());
        org.setInn(entity.getInn());
        org.setKpp(entity.getKpp());
        org.setActive(entity.getActive());
        org.setAddress(entity.getAddress());
        org.setPhone(entity.getPhone());
        return org;

    }

    public Organization() {
    }

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

