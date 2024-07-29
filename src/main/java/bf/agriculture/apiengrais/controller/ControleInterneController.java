/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.ControleInterne;
import bf.agriculture.apiengrais.services.ControleInterneService;
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
@RequestMapping("/api/controleInterne")

/**
 * acceder aux donner de la table ControleInterne
 */
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class ControleInterneController {

    @Autowired
    private ControleInterneService controleInterneService;

    
    /**
     * 
     * @param controleInterne
     * @return controleInternes ajouter
     */
    @PostMapping
    public ControleInterne save(@RequestBody ControleInterne controleInterne) {
        return controleInterneService.save(controleInterne);
    }
    
    
    /**
     * 
     * @return liste des controleInterne
     */
    @GetMapping
    public List<ControleInterne> findAll(){
        return controleInterneService.findAll();
    }
    
    
    /**
     * 
     * @param id
     * @return controleInterne par id
     */
    @GetMapping("/{id}")
    public ControleInterne findById(@PathVariable Long id){
        return controleInterneService.findById(id);
    }
    
    
    /**
     * 
     * @param controleInterne
     * @return Mise a jours des elements de la table region
     */
    @PutMapping
    public ControleInterne update(@RequestBody ControleInterne controleInterne) {
        return controleInterneService.save(controleInterne);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant libelle
     */
    @PatchMapping("/{id}")
    /*
    public ResponseEntity<Map<String, String>> updateLibelleControleInterne(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleControleInterne = updates.get("libelle");
        Optional<ControleInterne> updatedControleInterne = controleInterneService.updateLibelleControleInterne(id, newLibelleControleInterne);
        
        if (updatedControleInterne.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "ControleInterne updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */
    
    
    /**
     * 
     * @param id
     * @return controleInterne supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControleInterne(@PathVariable Long id) {
        controleInterneService.deleteControleInterneById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteControleInterne(@PathVariable Long id) {
        controleInterneService.deleteControleInterneById(id);
    }
*/

}
