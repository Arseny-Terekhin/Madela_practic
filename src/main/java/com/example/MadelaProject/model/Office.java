package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OfficeEntity;

public class Office {

    private Long id;
    private String name;
    private String address;
    private String phone;
    private Boolean isActive;

    public static Office toModel(OfficeEntity entity){
        Office office = new Office();
        office.setId(entity.getId());
        office.setName(entity.getName());
        office.setAddress(entity.getAddress());
        office.setPhone(entity.getPhone());
        office.setActive(entity.getActive());
        return office;
    }

    public Office() {
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
