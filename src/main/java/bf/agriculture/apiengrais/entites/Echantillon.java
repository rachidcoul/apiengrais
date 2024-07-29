/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
public class Echantillon {

    @Id
    private Long id;
    private Long numInspection;
    private Long numLabo;
    private Date datePrelevement;
    private Date dateReception;
    private Date dateRapport;

    @ManyToOne
    @JoinColumn(name = "id_controle_interne")
    @JsonBackReference
    private ControleInterne controleInterne;

    @ManyToOne
    @JoinColumn(name = "id_type_engrais")
    @JsonBackReference
    private TypeEngrais typeEngrais;

    @OneToMany(mappedBy = "echantillon", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Resultat> resultats;

}
