package com.example.cabinetmedicalback.service;

import com.example.cabinetmedicalback.DAO.PatientDAO;
import com.example.cabinetmedicalback.repository.PatientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository repo;

    @Autowired
    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    /**
     * Return the list of all the patients
     * @return
     */
    public List<PatientDAO> getAllPatient() {
        if (this.repo.findAll().size() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            return (this.repo.findAll());
        }
    }

    /**
     * Return a patient by the id
     * @param id
     * @return The patient found
     */
    public PatientDAO getPatientById(String id) {
        return (this.repo.findById(id).get());
    }

    /**
     * Return a patient by the name
     * @param name
     * @return
     */
    public PatientDAO getPatientByNomPatient(String name) {
        return(this.repo.getPatientByNomPatient(name));
    }

    /**
     * Create a new patient
     * @param newPatient the new patient which has to be added in the DB
     * @return
     */
    public PatientDAO createPatient(PatientDAO newPatient) {
        return (this.repo.insert(newPatient));
    }

    /**
     * Update a patient
     * Only adresse, sexe and dateNaissance can be updated
     * @param id the id of item which has to be updated
     * @param item the new value of the item
     * @return
     */
    public PatientDAO updatePatient(String id, PatientDAO item) {
        PatientDAO itemToUpdate = this.repo.findById(id).get();

        itemToUpdate.setNomPatient(item.getNomPatient());
        itemToUpdate.setPrenomPatient(item.getPrenomPatient());
        itemToUpdate.setDateNaissance(item.getDateNaissance());
        itemToUpdate.setSexe(item.getSexe());
        itemToUpdate.setAdresse(item.getAdresse());
        itemToUpdate.setNumeroSecu(item.getNumeroSecu());
        itemToUpdate.setInfirmier(item.getInfirmier());

        return(this.repo.save(itemToUpdate));
    }

    /**
     * Delete a patient
     * Consist in changing the patient from active to inactive
     * active = false
     * @param id
     */
    public void deletePatient(String id) {
        PatientDAO itemToDelete = this.repo.findById(id).get();
        itemToDelete.setActive(false);
        this.repo.save(itemToDelete);
    }

    /**
     * Activate a patient
     * Consist in changing the patient from inactive to active
     * active = true
     * @param id
     */
    public void activatePatient(String id) {
        PatientDAO itemToActivate = this.repo.findById(id).get();
        itemToActivate.setActive(true);
        this.repo.save(itemToActivate);
    }


}
