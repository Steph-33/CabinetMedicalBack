package com.example.cabinetmedicalback.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Patient")
public class PatientDAO {

    @Id
    private String id;
    private String nomPatient;
    private String prenomPatient;
    private String dateNaissance;
    private String sexe;
    private String adresse;
    private String numeroSecu;
    private boolean active;
    // @DBRef
    // private Infirmier infirmier;



}
