package com.example.cabinetmedicalback.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Infirmiers")
public class InfirmierDAO {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String telPro;
    private String telMobile;
    private String telFixe;
    private boolean active;
}