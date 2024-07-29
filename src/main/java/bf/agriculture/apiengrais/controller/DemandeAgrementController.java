/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.DemandeAgrement;
import bf.agriculture.apiengrais.services.DemandeAgrementService;
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
@RequestMapping("/api/demandeAgrement")

/**
 * acceder aux donner de la table DemandeAgrement
 */
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class DemandeAgrementController {

    @Autowired
    private DemandeAgrementService demandeAgrementService;

    
    /**
     * 
     * @param demandeAgrement
     * @return demandeAgrements ajouter
     */
    @PostMapping
    public DemandeAgrement save(@RequestBody DemandeAgrement demandeAgrement) {
        return demandeAgrementService.save(demandeAgrement);
    }
    
    
    /**
     * 
     * @return liste des demandeAgrement
     */
    @GetMapping
    public List<DemandeAgrement> findAll(){
        return demandeAgrementService.findAll();
    }
    
    
    /**
     * 
     * @param id
     * @return demandeAgrement par id
     */
    @GetMapping("/{id}")
    public DemandeAgrement findById(@PathVariable Long id){
        return demandeAgrementService.findById(id);
    }
    
    
    /**
     * 
     * @param demandeAgrement
     * @return Mise a jours des elements de la table region
     */
    @PutMapping
    public DemandeAgrement update(@RequestBody DemandeAgrement demandeAgrement) {
        return demandeAgrementService.save(demandeAgrement);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return actite modifier
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleDemandeAgrement(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newActiviteDemandeAgrement = updates.get("activite");
        Optional<DemandeAgrement> updatedDemandeAgrement = demandeAgrementService.updateActiviteDemandeAgrement(id, newActiviteDemandeAgrement);
        
        if (updatedDemandeAgrement.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "DemandeAgrement updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    /**
     * 
     * @param id
     * @return demandeAgrement supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemandeAgrement(@PathVariable Long id) {
        demandeAgrementService.deleteDemandeAgrementById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteDemandeAgrement(@PathVariable Long id) {
        demandeAgrementService.deleteDemandeAgrementById(id);
    }
*/

}
