package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OrganizationEntity;

public class OrganizationTwo {
    private Long id;
    private String name;
    private Boolean isActive;

    public static OrganizationTwo toModel(OrganizationEntity entity){
        OrganizationTwo organization = new OrganizationTwo();
        organization.setId(entity.getId());
        organization.setName(entity.getName());
        organization.setActive(entity.getActive());
        return organization;
    }

    public OrganizationTwo() {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
