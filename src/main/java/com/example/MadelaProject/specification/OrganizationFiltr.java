package com.example.MadelaProject.specification;

import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Component
public class OrganizationFiltr {

    @Autowired
    private OrganizationRepo organizationRepo;



    public List<OrganizationEntity> findByCondition(String name, String inn, Boolean isActive){
        List<OrganizationEntity> resultList = null;
        Specification querySpecifi = new Specification<OrganizationEntity>() {
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<OrganizationEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(null != name){
                    predicates.add(criteriaBuilder.like(root.get("name"), name));
                }
                if(null != inn){
                    predicates.add(criteriaBuilder.like(root.get("inn"), inn));
                }
                if(null != isActive){
                    predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = this.organizationRepo.findAll(querySpecifi);
        return resultList;
    }
}
