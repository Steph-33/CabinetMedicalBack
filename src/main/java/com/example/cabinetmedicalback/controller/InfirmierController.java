package com.example.cabinetmedicalback.controller;

import com.example.cabinetmedicalback.DAO.InfirmierDAO;
import com.example.cabinetmedicalback.DAO.PatientDAO;
import com.example.cabinetmedicalback.service.InfirmierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/infirmiers")
public class InfirmierController {

    private InfirmierService service;

    @Autowired
    public InfirmierController(InfirmierService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<InfirmierDAO> getAllInfirmiers() {
        return (this.service.getAllInfirmier());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public InfirmierDAO getInfirmierByID(@PathVariable String id) {
        return(this.service.getInfirmierById(id));
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public InfirmierDAO getInfirmierByName(@PathVariable String name) {
        return(this.service.getInfirmierByNom(name));
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public InfirmierDAO createInfirmier(@RequestBody InfirmierDAO newInfirmier) {
        return(this.service.createInfirmier(newInfirmier));
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public InfirmierDAO updateInfirmier(@PathVariable String id, @RequestBody InfirmierDAO item) {
        return(this.service.updateInfirmier(id, item));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteInfirmier(@PathVariable String id) {
        this.service.deleteInfirmier(id);
    }
}
