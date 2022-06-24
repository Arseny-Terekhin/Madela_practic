package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.CountryEntity;
import com.example.MadelaProject.entity.DocEntity;
import com.example.MadelaProject.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public CountryEntity save(DocEntity entity){
        return countryRepo.save(entity);
    }
}
