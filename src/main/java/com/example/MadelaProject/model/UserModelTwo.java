package com.example.MadelaProject.model;


import com.example.MadelaProject.entity.UserEntity;

import java.util.Date;

public class UserModelTwo {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long position;

    public static UserModelTwo toModel(UserEntity entity){
        UserModelTwo userModelTwo = new UserModelTwo();
        userModelTwo.setId(entity.getId());
        userModelTwo.setFirstName(entity.getFirstName());
        userModelTwo.setLastName(entity.getLastName());
        userModelTwo.setMiddleName(entity.getMiddleName());
        userModelTwo.setPosition(entity.getPosition());
        return userModelTwo;
    }

    public UserModelTwo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
