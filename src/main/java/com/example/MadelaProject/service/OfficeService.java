package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.OfficeEntity;
import com.example.MadelaProject.exeption.OfficeException;
import com.example.MadelaProject.model.Office;
import com.example.MadelaProject.repository.OfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {

    @Autowired
    OfficeRepo officeRepo;

    public OfficeEntity saveOffice(OfficeEntity office) throws OfficeException {
        if (officeRepo.findByName(office.getName()) != null){
            throw new OfficeException("офис с таким именем уже существует");
        }
        return officeRepo.save(office);
    }

    public OfficeEntity updateOffice(OfficeEntity office) throws OfficeException {
        if (officeRepo.findFirstById(office.getId()) == null){
            throw new OfficeException("офис с таким id не существует");
        }
        OfficeEntity officeEntity = officeRepo.findFirstById(office.getId());
        officeEntity.setId(office.getId());
        officeEntity.setAddress(office.getAddress());
        officeEntity.setActive(office.getActive());
        officeEntity.setPhone(office.getPhone());
        officeEntity.setName(office.getName());
        return officeRepo.save(officeEntity);
    }

    public Office getOne(Long id)throws OfficeException{
        if (officeRepo.findFirstById(id) == null){
            throw new OfficeException("офис с таким id не существует");
        }
        return Office.toModel(officeRepo.findFirstById(id));
    }
}
