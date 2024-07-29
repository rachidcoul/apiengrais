/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
public class Resultat {

    @Id
    private Long id;
    private Long valeurDeclaree;
    private Long valeurObetenue;

    @ManyToOne
    @JoinColumn(name = "id_element_nutritif")
    @JsonBackReference
    private ElementNutritif elementNutritif;

    @ManyToOne
    @JoinColumn(name = "id_echantillon")
    @JsonBackReference
    private Echantillon echantillon;

}
