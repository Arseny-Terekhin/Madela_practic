package com.example.MadelaProject.controller;


import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.exeption.OrganizationException;
import com.example.MadelaProject.exeption.UserAlreadyExistException;
import com.example.MadelaProject.service.OrganizationService;
import com.example.MadelaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody OrganizationEntity organization){
        try {
            organizationService.saveOrganization(organization);
            return ResponseEntity.ok("организация сохранина");
        }catch (OrganizationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody OrganizationEntity organization){
        try{
            organizationService.updateOrganization(organization);
            return ResponseEntity.ok("организация обновлена");
        }catch (OrganizationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOrganization(@PathVariable Long id)  {
        try{
            return ResponseEntity.ok(organizationService.getOne(id));
        }catch (OrganizationException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }


}
