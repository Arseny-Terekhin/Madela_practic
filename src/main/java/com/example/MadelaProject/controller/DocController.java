package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.DocEntity;
import com.example.MadelaProject.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
public class DocController {

    @Autowired
    private DocService docService;

    @PostMapping("/doc")
    public ResponseEntity dpc(DocEntity docEntity){
        try{
            docService.save(docEntity);
            return ResponseEntity.ok("doc сохранен");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }
}
