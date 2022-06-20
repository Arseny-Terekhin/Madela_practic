package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrganizationRepo extends CrudRepository<OrganizationEntity, Long> {
    OrganizationEntity findByName(String name);
    OrganizationEntity findFirstById(Long id);
}
