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
public class DemandeAgrement {

    @Id
    private Long id;
    private String agrement;
    private String activite;
    private String numRccm;
    private String numIfu;
    private Date dateDemande;
    private Boolean validationProvince;
    private Date dateValidationProvince;
    private Boolean validationRegion;
    private Date dateValidationRegion;
    private Boolean validationCentral;
    private Date dateValidationCentral;

    @ManyToOne
    @JoinColumn(name = "id_requerant")
    @JsonBackReference
    private Requerant requerant;

    @OneToMany(mappedBy = "demandeAgrement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ControleInterne> controleInternes;

    @OneToMany(mappedBy = "demandeAgrement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RenouvellementAgrement> renouvellementAgrements;

    @OneToMany(mappedBy = "demandeAgrement", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AutorisationImportation> autorisationImportation;

}
