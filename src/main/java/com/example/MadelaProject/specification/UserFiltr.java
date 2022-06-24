package com.example.MadelaProject.specification;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.entity.UserEntity;
import com.example.MadelaProject.repository.UserRepo;
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
public class UserFiltr {

    @Autowired
    private UserRepo repo;

    public List<UserEntity> findByCondition    (Long officeId, String firstName,
                                                String lastName, String middleName,
                                                String position, String docNumber,
                                                Long citizenshipCode){
        List<UserEntity> resultList = null;
        Specification querySpecifi = new Specification<UserEntity>() {
            @Override
            public javax.persistence.criteria.Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if(null != officeId) {
                    predicates.add(criteriaBuilder.like(root.get("officeId"), "%" + officeId + "%"));
                }

                if(null != firstName){
                    predicates.add(criteriaBuilder.like(root.get("firstName"), firstName));
                }
                if(null != lastName){
                    predicates.add(criteriaBuilder.like(root.get("lastName"), lastName));
                }
                if(null != middleName){
                    predicates.add(criteriaBuilder.equal(root.get("middleName"), middleName));
                }
                if(null != position){
                    predicates.add(criteriaBuilder.equal(root.get("position"), position));
                }
                if(null != docNumber){
                    predicates.add(criteriaBuilder.equal(root.get("docNumber"), docNumber));
                }
                if(null != citizenshipCode){
                    predicates.add(criteriaBuilder.equal(root.get("citizenshipCode"), citizenshipCode));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        resultList = this.repo.findAll(querySpecifi);
        return resultList;
    }
}
