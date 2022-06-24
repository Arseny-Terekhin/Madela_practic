package com.example.MadelaProject.repository;

import com.example.MadelaProject.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepo extends CrudRepository<OrganizationEntity, Long>, JpaSpecificationExecutor {
    OrganizationEntity findByName(String name);
    OrganizationEntity findFirstById(Long id);
    List<OrganizationEntity> findByNameLikeAndInnLikeAndIsActiveLike(String name, String inn, Boolean isActive);
}
