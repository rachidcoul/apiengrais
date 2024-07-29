/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class TypeEngrais {

    @Id
    private Long id;
    private String libelle;

    @OneToMany(mappedBy = "typeEngrais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Echantillon> echantillons;

    @OneToMany(mappedBy = "typeEngrais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ElementNutritif> ElementNutritif;
}
