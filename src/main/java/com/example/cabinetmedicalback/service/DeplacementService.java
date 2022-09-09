package com.example.cabinetmedicalback.service;

import com.example.cabinetmedicalback.DAO.DeplacementDAO;
import com.example.cabinetmedicalback.repository.DeplacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DeplacementService {
    private DeplacementRepository repo;
    @Autowired
    public DeplacementService(DeplacementRepository repo) {
        this.repo = repo;
    }

    public List<DeplacementDAO> getAllDeplacements(){
        return this.repo.findAll();
    }
    public List<DeplacementDAO> getDeplacementByPatient(String id){
        return this.repo.findAllByPatient(id);
    }

    public List<DeplacementDAO> getDeplacementByPatientAndInfirmier(String idPatient, String idInfirmier){
        return this.repo.findAllByPatientAndInfirmier(idPatient, idInfirmier);
    }

    public DeplacementDAO createDeplacement(DeplacementDAO item){
        return this.repo.insert(item);
    }

    public DeplacementDAO updateDeplacement(String id, DeplacementDAO item){
        if(this.repo.existsById(id)){
            return this.repo.save(item);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public DeplacementDAO patchDeplacementCout(String id, Long item){
        if(this.repo.existsById(id)){
            DeplacementDAO obj = this.repo.findById(id).get();
            obj.setCout(item);
            this.repo.save(obj);
            return obj;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public DeplacementDAO patchDeplacementDate(String id, String item){
        if(this.repo.existsById(id)){
            DeplacementDAO obj = this.repo.findById(id).get();
            obj.setDate(item);
            this.repo.save(obj);
            return obj;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    public String deleteDeplacement(String id){
        if(this.repo.existsById(id)){
            this.repo.deleteById(id);
            return "{}";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


}
