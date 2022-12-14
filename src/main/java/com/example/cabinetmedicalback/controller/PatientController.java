package com.example.cabinetmedicalback.controller;

import com.example.cabinetmedicalback.DAO.PatientDAO;
import com.example.cabinetmedicalback.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/patients")
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PatientDAO> getAllPatients() {
        return (this.service.getAllPatient());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PatientDAO getPatientByID(@PathVariable String id) {
        return(this.service.getPatientById(id));
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public PatientDAO getPatientByName(@PathVariable String name) {
        return(this.service.getPatientByNomPatient(name));
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public PatientDAO createPatient(@RequestBody PatientDAO newPatient) {
        return(this.service.createPatient(newPatient));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePatient(@PathVariable String id) {
        this.service.deletePatient(id);
    }

    @PatchMapping("/active/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void activatePatient(@PathVariable String id) {
        this.service.activatePatient(id);
    }

    @PatchMapping("/update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PatientDAO updatePatient(@PathVariable String id, @RequestBody PatientDAO item) {
        return(this.service.updatePatient(id, item));
    }

}
