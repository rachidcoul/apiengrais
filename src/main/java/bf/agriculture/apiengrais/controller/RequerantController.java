/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Requerant;
import bf.agriculture.apiengrais.services.RequerantService;
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
@RequestMapping("/api/requerants")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class RequerantController {

    @Autowired
    private RequerantService requerantService;

    
    /**
     * 
     * @param requerant
     * @return ajouter un requerant
     */
    @PostMapping
    public Requerant save(@RequestBody Requerant requerant) {
        return requerantService.save(requerant);
    }
        
    /**
     * 
     * @return liste des requerants
     */
    @GetMapping
    public List<Requerant> findAll(){
        return requerantService.getSortedRequerantsByNomPrenom();
    }
    
    
    /**
     * 
     * @param id
     * @return liste des requerants par id
     */
    @GetMapping("/{id}")
    public Requerant findById(@PathVariable Long id){
        return requerantService.findById(id);
    }
    
    
    /**
     * 
     * @param requerant
     * @return Mise a jours des elements de la table region
     */
    @PostMapping("/{id}")
    public Requerant update(@RequestBody Requerant requerant) {
        return requerantService.save(requerant);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant NomPrenom modifier
     */
    @PatchMapping("/{id}/nom_prenom")
    public ResponseEntity<Map<String, String>> updateNomPrenonRequerant(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newNomPrenonRequerant = updates.get("nom_prenom");
        Optional<Requerant> updatedRequerant = requerantService.updateNomPrenomRequerant(id, newNomPrenonRequerant);
        
        if (updatedRequerant.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Requerant updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 
     * @param id
     * @param updates
     * @return modifier le contact de libelle
     */
    @PatchMapping("/{id}/contact")
    public ResponseEntity<Map<String, String>> updateContactRequerant(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newContactRequerant = updates.get("contact");
        Optional<Requerant> updatedRequerant = requerantService.updateContactRequerant(id, newContactRequerant);
        
        if (updatedRequerant.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Requerant updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 
     * @param id
     * @param updates
     * @return modifier le email de requerant
     */
    @PatchMapping("/{id}/email")
    public ResponseEntity<Map<String, String>> updateEmailRequerant(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newEmailRequerant = updates.get("email");
        Optional<Requerant> updatedRequerant = requerantService.updateEmailRequerant(id, newEmailRequerant);
        
        if (updatedRequerant.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Requerant updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    /**
     * 
     * @param id
     * @return requerant supprimer un requerant avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequerant(@PathVariable Long id) {
        requerantService.deleteRequerantById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteRequerant(@PathVariable Long id) {
        requerantService.deleteRequerantById(id);
    }
*/

}
