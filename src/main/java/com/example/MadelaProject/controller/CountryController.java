package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.DocEntity;
import com.example.MadelaProject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping("/country")
    public ResponseEntity doc(@RequestBody DocEntity entity){
        try{
            countryService.save(entity);
            return ResponseEntity.ok("country сохранен");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }
}
