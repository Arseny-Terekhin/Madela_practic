package com.example.MadelaProject.specification;


import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.entity.OrganizationEntity;
import com.example.MadelaProject.repository.OfficeRepo;
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
public class OfficeFiltr {

    @Autowired
    private OfficeRepo officeRepo;


    public List<OfficeEntity> findByCondition    (Long orgId, String name, String phone, Boolean isActive){
        List<OfficeEntity> resultList = null;
        Specification querySpecifi = new Specification<OfficeEntity>() {
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<OfficeEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(null != orgId) {
                    predicates.add(criteriaBuilder.like(root.get("orgId"), "%" + orgId + "%"));
                }

                if(null != name){
                    predicates.add(criteriaBuilder.like(root.get("name"), name));
                }
                if(null != phone){
                    predicates.add(criteriaBuilder.like(root.get("phone"), phone));
                }
                if(null != isActive){
                    predicates.add(criteriaBuilder.equal(root.get("isActive"), isActive));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = this.officeRepo.findAll(querySpecifi);
        return resultList;
    }
}
