package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.exeption.OfficeException;
import com.example.MadelaProject.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/office")
public class OfficeController {

    @Autowired
    OfficeService officeServise;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody OfficeEntity officeEntity){
        try {
            officeServise.saveOffice(officeEntity);
            return ResponseEntity.ok("офис сохранен");
        }catch (OfficeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody OfficeEntity officeEntity){
        try {
            officeServise.updateOffice(officeEntity);
            return ResponseEntity.ok("офис обновлен");
        }catch (OfficeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOffice(@PathVariable Long id){
        try {
            return ResponseEntity.ok(officeServise.getOne(id));
        }catch (OfficeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

}
