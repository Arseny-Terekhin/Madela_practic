package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.exeption.OrganizationException;
import com.example.MadelaProject.model.Organization;
import com.example.MadelaProject.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepo organizationRepo;

    public OrganizationEntity saveOrganization(OrganizationEntity organizationEntity) throws OrganizationException {
        if (organizationRepo.findByName(organizationEntity.getName()) != null){
            throw new OrganizationException("Организация с таким именем уже существует");
        }
        return organizationRepo.save(organizationEntity);
    }

    public OrganizationEntity updateOrganization(OrganizationEntity organizationEntity) throws OrganizationException {
        if (organizationRepo.findFirstById(organizationEntity.getId()) == null){
            throw new OrganizationException("Организация с таким именем не существует");
        }
        OrganizationEntity organization = organizationRepo.findFirstById(organizationEntity.getId());
        organization.setName(organizationEntity.getName());
        organization.setAddress(organizationEntity.getAddress());
        organization.setFullName(organizationEntity.getFullName());
        organization.setPhone(organizationEntity.getPhone());
        organization.setInn(organizationEntity.getInn());
        organization.setKpp(organizationEntity.getKpp());
        organization.setActive(organizationEntity.getActive());
        return organizationRepo.save(organization);

    }

    public Organization getOne(Long id) throws OrganizationException {
        OrganizationEntity organization = organizationRepo.findFirstById(id);
        if (organization == null){
            throw new OrganizationException("Организация с таким именем не существует");
        }
        return Organization.toModel(organization);
    }

}
