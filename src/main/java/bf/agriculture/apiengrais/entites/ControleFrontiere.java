/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author car
 */
@Entity
@Table
@Getter
@Setter
@ToString
public class ControleFrontiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateControle;
    private Boolean conformiteDocument;
    private String typeEntreeSortie;
    private Long quantite;
    private Long quantiteInterieur;
    private Long quantiteExterieur;

    @ManyToOne
    @JoinColumn(name = "id_autorisation_importation")
    @JsonBackReference
    private AutorisationImportation autorisationImportation;
    
    public static List<ControleFrontiere> sortControleFrontieresByDateControle(List<ControleFrontiere> controleFrontieres) {
        Collections.sort(controleFrontieres, Comparator.comparing(ControleFrontiere::getDateControle));
        return controleFrontieres;
    }

}
