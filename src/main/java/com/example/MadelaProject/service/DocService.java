package com.example.MadelaProject.service;

import com.example.MadelaProject.entity.DocEntity;
import com.example.MadelaProject.repository.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocService {

    @Autowired
    private DocRepo docRepo;

    public DocEntity save(DocEntity doc){
        return docRepo.save(doc);
    }
}
