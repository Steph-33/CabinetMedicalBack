package com.example.cabinetmedicalback.repository;

import com.example.cabinetmedicalback.DAO.DeplacementDAO;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface DeplacementRepository extends MongoRepository<DeplacementDAO, String>{

}
