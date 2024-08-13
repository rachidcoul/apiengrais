/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Region implements Serializable {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeDgess;
    private String codeIgb;
    private String libelle;
    
    @OneToMany (mappedBy = "region")
    @JsonManagedReference
    @JsonIgnore
    private List<Province> provinces;
    
    
    public static List<Region> sortRegionsByLibelle(List<Region> regions) {
        Collections.sort(regions, Comparator.comparing(Region::getLibelle));
        return regions;
    }

}
