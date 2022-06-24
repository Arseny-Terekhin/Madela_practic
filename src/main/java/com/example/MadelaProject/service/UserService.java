package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.exeption.ActivationCodeException;
import com.example.MadelaProject.exeption.UserAlreadyExistException;
import com.example.MadelaProject.model.OrganizationTwo;
import com.example.MadelaProject.model.User;
import com.example.MadelaProject.model.UserModelTwo;
import com.example.MadelaProject.repository.UserRepo;
import com.example.MadelaProject.specification.UserFiltr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserFiltr userFiltr;

    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findByLogin(userEntity.getLogin()) != null){
            throw new UserAlreadyExistException("пользователь с таким логином уже существует уже существует");
        }
        return userRepo.save(userEntity);
    }

    public UserEntity login(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findByLogin(userEntity.getLogin()) == null){
            throw new UserAlreadyExistException("пользователь с таким логином не существует");
        }
        UserEntity user = userRepo.findByLogin(userEntity.getLogin());
        if (user.getPassword().equals(userEntity.getPassword()) == false){
            throw new UserAlreadyExistException("пароль не верный");
        }
        return user;
    }

    public String generateCode(){
        String simCode = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOASDFGHJKLZXCVBNM1234567890!@#$%^&*()_+";
        Random random = new Random();
        char sim;
        String code = "";
        int index;
        for (int i = 0; i < 6; i++){
            index = random.nextInt(simCode.length());
            sim = simCode.charAt(index);
            code += sim;
        }
        return code;
    }

    public void activation(String code, String codeActivation) throws ActivationCodeException {
        if (code.equals(codeActivation) != true ){
            throw new ActivationCodeException("код не верный");
        }
    }

    public UserEntity saveUser(UserEntity userEntity) throws UserAlreadyExistException {
        return userRepo.save(userEntity);
    }

    public UserEntity updateUser(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findFirstById(userEntity.getId()) != null){
            throw new UserAlreadyExistException("пользователь с таким id не существует");
        }
        UserEntity user = userRepo.findFirstById(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setMiddleName(userEntity.getMiddleName());
        user.setPosition(userEntity.getPosition());
        user.setPhone(userEntity.getPhone());
        user.setDocName(userEntity.getDocName());
        user.setDocDate(userEntity.getDocDate());
        user.setDocNumber(userEntity.getDocNumber());
        user.setCitizenshipCode(userEntity.getCitizenshipCode());
        user.setCitizenshipName(userEntity.getCitizenshipName());
        user.setIdentified(userEntity.getIdentified());
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserAlreadyExistException {
        UserEntity user = userRepo.findFirstById(id);
        if (user == null){
            throw new UserAlreadyExistException("пользователь с таким id не существует");
        }
        return User.toModel(user);
    }


    public List<UserModelTwo> list(Long officeId, String firstName,
                                   String lastName, String middleName,
                                   String position, String docNumber,
                                   Long citizenshipCode){
        List<UserEntity> user = userFiltr.findByCondition(officeId,firstName, lastName, middleName, position, docNumber, citizenshipCode);
        return user.stream().map(UserModelTwo::toModel).collect(Collectors.toList());
    }

}
