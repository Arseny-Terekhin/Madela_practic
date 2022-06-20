package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long>{
    UserEntity findByLogin(String login);
    UserEntity findFirstById(Long id);

}
