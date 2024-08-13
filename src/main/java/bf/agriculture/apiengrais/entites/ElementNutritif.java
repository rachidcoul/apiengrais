/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
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
public class ElementNutritif implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_type_engrais")
    @JsonBackReference
    private TypeEngrais typeEngrais;

    @OneToMany(mappedBy = "elementNutritif")
    @JsonManagedReference
    @JsonIgnore
    private List<Resultat> resultats;
    
    public static List<ElementNutritif> sortElementNutritifsByLibelle(List<ElementNutritif> elementNutritifs) {
        Collections.sort(elementNutritifs, Comparator.comparing(ElementNutritif::getLibelle));
        return elementNutritifs;
    }

}
