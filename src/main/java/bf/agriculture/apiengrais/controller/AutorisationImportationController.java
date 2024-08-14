/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.AutorisationImportation;
import bf.agriculture.apiengrais.services.AutorisationImportationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author car
 */
@RestController
@RequestMapping("/api/autorisationImportations")

/**
 * acceder aux donner de la table AutorisationImportation
 */
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class AutorisationImportationController {

    @Autowired
    private AutorisationImportationService autorisationImportationService;

    /**
     *
     * @param autorisationImportation
     * @return autorisationImportations ajouter
     */
    @PostMapping
    public AutorisationImportation save(@RequestBody AutorisationImportation autorisationImportation) {
        return autorisationImportationService.save(autorisationImportation);
    }

    /**
     *
     * @return liste des autorisationImportation
     */
    @GetMapping
    public List<AutorisationImportation> findAll() {
        return autorisationImportationService.getSortedAutorisationImportationsByNumero();
    }

    /**
     *
     * @param id
     * @return liste des autorisationImportation par id
     */
    @GetMapping("/{id}")
    public AutorisationImportation findById(@PathVariable Long id) {
        return autorisationImportationService.findById(id);
    }

    /**
     *
     * @param autorisationImportation
     * @return Mise d'une autorisation d'importation
     */
    @PutMapping
    public AutorisationImportation update(@RequestBody AutorisationImportation autorisationImportation) {
        return autorisationImportationService.save(autorisationImportation);
    }

    /**
     *
     * @param id
     * @param updates
     * @return modifier le libelle d'une autorisation d'importation
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleAutorisationImportation(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleAutorisationImportation = updates.get("libelle");
        Optional<AutorisationImportation> updatedAutorisationImportation = autorisationImportationService.updateLibelleAutorisationImportation(id, newLibelleAutorisationImportation);

        if (updatedAutorisationImportation.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "AutorisationImportation updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     *
     * @param id
     * @return autorisationImportation supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutorisationImportation(@PathVariable Long id) {
        autorisationImportationService.deleteAutorisationImportationById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteAutorisationImportation(@PathVariable Long id) {
        autorisationImportationService.deleteAutorisationImportationById(id);
    }
     */
}
