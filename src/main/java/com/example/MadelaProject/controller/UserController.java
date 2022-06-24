package com.example.MadelaProject.controller;

import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exeption.ActivationCodeException;
import com.example.MadelaProject.exeption.UserAlreadyExistException;
import com.example.MadelaProject.repository.UserRepo;
import com.example.MadelaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    UserService userService;
    private String codeActivation;

    @PostMapping("/register")
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            codeActivation = userService.generateCode();
            System.out.println(codeActivation);
            return ResponseEntity.ok("пользователь создан");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @GetMapping("/activation")
    public ResponseEntity activation(@RequestParam String code){
        try {
            userService.activation(code, codeActivation);
            return ResponseEntity.ok("код правиоьный");
        } catch (ActivationCodeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity user){
        try {
            userService.login(user);
            return ResponseEntity.ok("успешный вход");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }

    }

    @PostMapping("/user/save")
    public ResponseEntity saveUser(@RequestBody UserEntity user){
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("пользователь сохранен");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @PostMapping("/user/update")
    public ResponseEntity updateUser(@RequestBody UserEntity user){
        try {
            userService.updateUser(user);
            return ResponseEntity.ok("пользователь обновлен");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }
    }


    @PostMapping("/user/list")
    public ResponseEntity list(@RequestParam  Long officeId, @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,  @RequestParam(required = false) String middleName,
                               @RequestParam(required = false) String position,  @RequestParam(required = false) String docNumber,
                               @RequestParam(required = false)  Long citizenshipCode){
        try {
            return ResponseEntity.ok(userService.list(officeId,firstName, lastName, middleName, position, docNumber, citizenshipCode));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("eror");
        }

    }





}
