/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Commune;
import bf.agriculture.apiengrais.services.CommuneService;
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
@RequestMapping("/api/communes")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class CommuneController {

    @Autowired
    private CommuneService communeService;

    @PostMapping
    public Commune save(@RequestBody Commune commune) {
        return communeService.save(commune);
    }
    
    @GetMapping
    public List<Commune> findAll(){
        return communeService.getSortedCommunesByLibelle();
    }
    
    @GetMapping("/{id}")
    public Commune findById(@PathVariable Long id){
        return communeService.findById(id);
    }
    
    @PutMapping
    //pour faire l'operatiob de Mise a jours sur les element de la table region
    public Commune update(@RequestBody Commune commune) {
        return communeService.save(commune);
    }
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant libelle
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleCommune(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleCommune = updates.get("libelle");
        Optional<Commune> updatedCommune = communeService.updateLibelleCommune(id, newLibelleCommune);
        
        if (updatedCommune.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Commune Modifier avec succes");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //supression avec message de confirmation bon
    /**
     * 
     * @param id
     * @return la commune supprimer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommune(@PathVariable Long id) {
        communeService.deleteCommuneById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteCommune(@PathVariable Long id) {
        communeService.deleteCommuneById(id);
    }
*/

}
