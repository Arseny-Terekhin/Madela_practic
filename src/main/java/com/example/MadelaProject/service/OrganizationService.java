package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.exeption.OrganizationException;
import com.example.MadelaProject.model.Organization;
import com.example.MadelaProject.model.OrganizationTwo;
import com.example.MadelaProject.repository.OrganizationRepo;
import com.example.MadelaProject.specification.OrganizationFiltr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepo organizationRepo;

    @Autowired
    private OrganizationFiltr organizationFiltr;

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

    public List<OrganizationTwo> list(String name, String inn, Boolean isActive) throws OrganizationException {
        List<OrganizationEntity> organization = organizationFiltr.findByCondition(name,inn, isActive);
        return organization.stream().map(OrganizationTwo::toModel).collect(Collectors.toList());
    }

}
