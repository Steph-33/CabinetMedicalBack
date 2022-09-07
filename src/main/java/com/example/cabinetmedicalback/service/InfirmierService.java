package com.example.cabinetmedicalback.service;

import com.example.cabinetmedicalback.DAO.InfirmierDAO;
import com.example.cabinetmedicalback.repository.InfirmierRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InfirmierService {

    private InfirmierRepository repo;

    @Autowired
    public InfirmierService(InfirmierRepository repo) {
        this.repo = repo;
    }

    /**
     * Return the list of all the infirmiers
     * @return
     */
    public List<InfirmierDAO> getAllInfirmier() {
        if (this.repo.findAll().size() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } else {
            return (this.repo.findAll());
        }
    }

    /**
     * Return an infirmier from the id
     * @param id
     * @return The infirmier found
     */
    public InfirmierDAO getInfirmierById(String id) {
        return (this.repo.findById(id).get());
    }

    /**
     * Return a infirmier by the name
     * @param name
     * @return
     */
    public InfirmierDAO getInfirmierByNom(String name) {
        return(this.repo.getInfirmierByNom(name));
    }


    /**
     * Create a new infirmier
     * @param newInfirmier the new infirmier which has to be added in the DB
     * @return
     */
    public InfirmierDAO createInfirmier(InfirmierDAO newInfirmier) {
        return (this.repo.insert(newInfirmier));
    }

    /**
     * Update an infirmier
     * Only telPro, telMobile, telFixe can be updated
     * @param id the id of item which has to be updated
     * @param item the new value of the item
     * @return
     */
    public InfirmierDAO updateInfirmier(String id, InfirmierDAO item) {
        InfirmierDAO itemToUpdate = this.repo.findById(id).get();

        itemToUpdate.setNom(item.getNom());
        itemToUpdate.setPrenom(item.getPrenom());
        itemToUpdate.setTelPro(item.getTelPro());
        itemToUpdate.setTelMobile(item.getTelMobile());
        itemToUpdate.setTelFixe(item.getTelFixe());

        return(this.repo.save(itemToUpdate));
    }

    /**
     * Delete an infirmier
     * Consist in changing the infirmier from active to inactive
     * @param id
     */
    public void deleteInfirmier(String id) {
        InfirmierDAO itemToDelete = this.repo.findById(id).get();
        itemToDelete.setActive(false);
        this.repo.save(itemToDelete);
    }
}
