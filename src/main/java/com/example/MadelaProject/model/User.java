package com.example.MadelaProject.model;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.entity.UserEntity;

import java.util.Date;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long position;
    private String phone;
    private String docName;
    private Long docNumber;
    private Date docDate;
    private String citizenshipName;
    private Long citizenshipCode;
    private Boolean isIdentified;

    public static User toModel(UserEntity entity){
        User user = new User();
        user.setId(entity.getId());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setMiddleName(entity.getMiddleName());
        user.setPhone(entity.getPhone());
        user.setPosition(entity.getPosition());
        user.setDocName(entity.getDocName());
        user.setDocDate(entity.getDocDate());
        user.setDocNumber(entity.getDocNumber());
        user.setCitizenshipCode(entity.getCitizenshipCode());
        user.setCitizenshipName(entity.getCitizenshipName());
        user.setIdentified(entity.getIdentified());
        return user;
    }

    public User() {}

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public Long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
