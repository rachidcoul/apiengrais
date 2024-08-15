/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.ElementNutritif;
import bf.agriculture.apiengrais.services.ElementNutritifService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author car
 */
@RestController
@RequestMapping("/api/elementNutritifs")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class ElementNutritifController {

    @Autowired
    private ElementNutritifService elementNutritifService;

    
    /**
     * 
     * @param elementNutritif
     * @return ajouter elementNutritifs 
     */
    @PostMapping
    public ElementNutritif save(@RequestBody ElementNutritif elementNutritif) {
        return elementNutritifService.save(elementNutritif);
    }
    
    
    /**
     * 
     * @return liste des elementNutritif
     */
    @GetMapping
    public List<ElementNutritif> findAll(){
        return elementNutritifService.getSortedElementNutritifsByLibelle();
    }
    
    
    /**
     * 
     * @param id
     * @return liste d'un elementNutritif par id
     */
    @GetMapping("/{id}")
    public ElementNutritif findById(@PathVariable Long id){
        return elementNutritifService.findById(id);
    }
    
    
    /**
     * 
     * @param elementNutritif
     * @return Mise a jours des elements de la table region
     */
    @PostMapping("/{id}")
    public ElementNutritif update(@RequestBody ElementNutritif elementNutritif) {
        return elementNutritifService.save(elementNutritif);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant libelle modifier
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleElementNutritif(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleElementNutritif = updates.get("libelle");
        Optional<ElementNutritif> updatedElementNutritif = elementNutritifService.updateLibelleElementNutritif(id, newLibelleElementNutritif);
        
        if (updatedElementNutritif.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "ElementNutritif updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    /**
     * 
     * @param id
     * @return elementNutritif supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementNutritif(@PathVariable Long id) {
        elementNutritifService.deleteElementNutritifById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteElementNutritif(@PathVariable Long id) {
        elementNutritifService.deleteElementNutritifById(id);
    }
*/

}
