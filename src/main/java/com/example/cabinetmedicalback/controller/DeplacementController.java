package com.example.cabinetmedicalback.controller;

import com.example.cabinetmedicalback.DAO.DeplacementDAO;
import com.example.cabinetmedicalback.service.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/deplacements")
public class DeplacementController {
    private DeplacementService service;

    @Autowired
    public DeplacementController(DeplacementService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<DeplacementDAO> getDeplacementPatient(@PathVariable String id){
        return service.getDeplacementByPatient(id);
    }

    @GetMapping("/{idPatient}/{idInfirmier}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<DeplacementDAO> getDeplacementPatientAndInfirmier(@PathVariable String idPatient, @PathVariable String idInfirmier){
        return service.getDeplacementByPatientAndInfirmier(idPatient, idInfirmier);
    }




    @PostMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public DeplacementDAO postDeplacement(@RequestBody DeplacementDAO item){
        return service.createDeplacement(item);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public DeplacementDAO putDeplacement(@PathVariable String id, @RequestBody DeplacementDAO item){
        return service.updateDeplacement(id, item);
    }

    @PatchMapping("/cout/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public DeplacementDAO patchDeplacementCout(@PathVariable String id, @RequestBody Long item){
        return service.patchDeplacementCout(id, item);
    }

    @PatchMapping("/date/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public DeplacementDAO patchDeplacementDate(@PathVariable String id, @RequestBody String item){
        return service.patchDeplacementDate(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteDeplacement(@PathVariable String id){
        return service.deleteDeplacement(id);
    }
}
