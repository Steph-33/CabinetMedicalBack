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

    /**
     * Récupération de tous les déplacements
     * @return
     */
    public List<DeplacementDAO> getAllDeplacements(){
        return this.repo.findAll();
    }

    /**
     * Récupération des déplacements par patient
     * @param id
     * @return
     */
    public List<DeplacementDAO> getDeplacementByPatient(String id){
        return this.repo.findAllByPatient(id);
    }

    /**
     * Récupération des déplacements par patient et par infirmier
     * @param idPatient
     * @param idInfirmier
     * @return
     */
    public List<DeplacementDAO> getDeplacementByPatientAndInfirmier(String idPatient, String idInfirmier){
        return this.repo.findAllByPatientAndInfirmier(idPatient, idInfirmier);
    }

    /**
     * Création d'un déplacement
     * @param item
     * @return
     */
    public DeplacementDAO createDeplacement(DeplacementDAO item){
        return this.repo.insert(item);
    }

    /**
     * Mise à jour d'un déplacement
     * @param id
     * @param item
     * @return
     */
    public DeplacementDAO updateDeplacement(String id, DeplacementDAO item){
        if(this.repo.existsById(id)){
            return this.repo.save(item);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Mise à jour du coût d'un déplacement
     * @param id
     * @param item
     * @return
     */
    public DeplacementDAO patchDeplacementCout(String id, Long item){
        if(this.repo.existsById(id)){
            DeplacementDAO obj = this.repo.findById(id).get();
            obj.setCout(item);
            this.repo.save(obj);
            return obj;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Mise à jour de la date d'un déplacement
     * @param id
     * @param item
     * @return
     */
    public DeplacementDAO patchDeplacementDate(String id, String item){
        if(this.repo.existsById(id)){
            DeplacementDAO obj = this.repo.findById(id).get();
            obj.setDate(item);
            this.repo.save(obj);
            return obj;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    /**
     * Suppression d'un déplacement
     * @param id
     * @return
     */
    public String deleteDeplacement(String id){
        if(this.repo.existsById(id)){
            this.repo.deleteById(id);
            return "{}";
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
