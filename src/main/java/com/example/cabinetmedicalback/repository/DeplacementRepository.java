package com.example.cabinetmedicalback.repository;

import com.example.cabinetmedicalback.DAO.DeplacementDAO;
import com.example.cabinetmedicalback.DAO.PatientDAO;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface DeplacementRepository extends MongoRepository<DeplacementDAO, String>{

    @Override
    List<DeplacementDAO> findAll();
    List<DeplacementDAO> findAllByPatient(String id);
    List<DeplacementDAO> findAllByPatientAndInfirmier(String idPatient, String idInfirmier);
}
