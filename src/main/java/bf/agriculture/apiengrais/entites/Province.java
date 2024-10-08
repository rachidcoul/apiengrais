/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
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
public class Province implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeDgess;
    private String codeIgb;
    private String libelle;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_region")
    private Region region;

    @OneToMany(mappedBy = "province")
    @JsonManagedReference
    @JsonIgnore
    private List<Commune> communes;

}
