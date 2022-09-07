package com.example.cabinetmedicalback.repository;

import com.example.cabinetmedicalback.DAO.InfirmierDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfirmierRepository extends MongoRepository<InfirmierDAO, String> {

    InfirmierDAO getInfirmierByNom(String nom);
}
