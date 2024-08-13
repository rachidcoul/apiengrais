/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.ControleFrontiere;
import bf.agriculture.apiengrais.services.ControleFrontiereService;
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
@RequestMapping("/api/controleFrontieres")

@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class ControleFrontiereController {

    @Autowired
    private ControleFrontiereService controleFrontiereService;

    /**
     * 
     * @param controleFrontiere
     * @return ajouter un controleFrontiere
     */
    @PostMapping
    public ControleFrontiere save(@RequestBody ControleFrontiere controleFrontiere) {
        return controleFrontiereService.save(controleFrontiere);
    }
    
    /**
     * 
     * @return liste des controleFrontieres
     */
    @GetMapping
    public List<ControleFrontiere> findAll(){
        return controleFrontiereService.getSortedFrontieresByDateControle();
    }
    
    /**
     * 
     * @param id
     * @return liste des controleFrontiere par id
     */
    @GetMapping("/{id}")
    public ControleFrontiere findById(@PathVariable Long id){
        return controleFrontiereService.findById(id);
    }
    
    @PutMapping
    //pour faire l'operatiob de Mise a jours sur les element de la table region
    public ControleFrontiere update(@RequestBody ControleFrontiere controleFrontiere) {
        return controleFrontiereService.save(controleFrontiere);
    }
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant libelle
     */
    /* apres il faut implementer pour la methode pour la modification de la quantitée
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleControleFrontiere(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleControleFrontiere = updates.get("libelle");
        Optional<ControleFrontiere> updatedControleFrontiere = controleFrontiereService.updateLibelleControleFrontiere(id, newLibelleControleFrontiere);
        
        if (updatedControleFrontiere.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "ControleFrontiere updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    */
    
    
    //supression avec message de confirmation bon
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteControleFrontiere(@PathVariable Long id) {
        controleFrontiereService.deleteControleFrontiereById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteControleFrontiere(@PathVariable Long id) {
        controleFrontiereService.deleteControleFrontiereById(id);
    }
*/

}
