package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OfficeEntity;

public class OfficeModelTwo {
    private Long id;
    private String name;
    private Boolean isActive;

    public static OfficeModelTwo toModel(OfficeEntity entity){
        OfficeModelTwo officeModelTwo = new OfficeModelTwo();
        officeModelTwo.setId(entity.getId());
        officeModelTwo.setName(entity.getName());
        officeModelTwo.setActive(entity.getActive());
        return officeModelTwo;
    }

    public OfficeModelTwo() {
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
