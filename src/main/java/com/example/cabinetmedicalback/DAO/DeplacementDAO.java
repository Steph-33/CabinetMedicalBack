package com.example.cabinetmedicalback.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Deplacements")
public class DeplacementDAO {
    @Id
    private String id;
    private Long cout;
    private String date;
}
