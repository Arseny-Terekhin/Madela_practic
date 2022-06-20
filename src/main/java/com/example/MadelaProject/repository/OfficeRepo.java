package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.entity.OrganizationEntity;
import org.springframework.data.repository.CrudRepository;

public interface OfficeRepo extends CrudRepository<OfficeEntity, Long> {
    OfficeEntity findByName(String name);
    OfficeEntity findFirstById(Long id);
}
