/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.RenouvellementAgrement;
import bf.agriculture.apiengrais.services.RenouvellementAgrementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author car
 */
@RestController
@RequestMapping("/api/renouvellementAgrements")

/**
 * acceder aux donner de la table RenouvellementAgrement
 */
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class RenouvellementAgrementController {

    @Autowired
    private RenouvellementAgrementService renouvellementAgrementService;

    /**
     *
     * @param renouvellementAgrement
     * @return renouvellementAgrements ajouter
     */
    @PostMapping
    public RenouvellementAgrement save(@RequestBody RenouvellementAgrement renouvellementAgrement) {
        return renouvellementAgrementService.save(renouvellementAgrement);
    }

    /**
     *
     * @return liste des renouvellementAgrement
     */
    @GetMapping
    public List<RenouvellementAgrement> findAll() {
        return renouvellementAgrementService.findAll();
    }

    /**
     *
     * @param id
     * @return renouvellementAgrement par id
     */
    @GetMapping("/{id}")
    public RenouvellementAgrement findById(@PathVariable Long id) {
        return renouvellementAgrementService.findById(id);
    }

    /**
     *
     * @param renouvellementAgrement
     * @return Mise a jours des elements de la table region
     */
    @PostMapping("/{id}")
    public RenouvellementAgrement update(@RequestBody RenouvellementAgrement renouvellementAgrement) {
        return renouvellementAgrementService.save(renouvellementAgrement);
    }

    /**
     *
     * @param id
     * @return renouvellementAgrement supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRenouvellementAgrement(@PathVariable Long id) {
        renouvellementAgrementService.deleteRenouvellementAgrementById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteRenouvellementAgrement(@PathVariable Long id) {
        renouvellementAgrementService.deleteRenouvellementAgrementById(id);
    }
     */
}
