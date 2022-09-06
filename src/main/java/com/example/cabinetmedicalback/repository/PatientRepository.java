package com.example.cabinetmedicalback.repository;

import com.example.cabinetmedicalback.DAO.PatientDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<PatientDAO, String> {
}
