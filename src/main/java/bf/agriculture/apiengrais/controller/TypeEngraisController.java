/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.TypeEngrais;
import bf.agriculture.apiengrais.services.TypeEngraisService;
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
@RequestMapping("/api/typeEngrais")

/**
 * acceder aux donner de la table TypeEngrais
 */
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class TypeEngraisController {

    @Autowired
    private TypeEngraisService typeEngraisService;

    
    /**
     * 
     * @param typeEngrais
     * @return typeEngraiss ajouter
     */
    @PostMapping
    public TypeEngrais save(@RequestBody TypeEngrais typeEngrais) {
        return typeEngraisService.save(typeEngrais);
    }
    
    
    /**
     * 
     * @return liste des typeEngrais
     */
    @GetMapping
    public List<TypeEngrais> findAll(){
        return typeEngraisService.findAll();
    }
    
    
    /**
     * 
     * @param id
     * @return typeEngrais par id
     */
    @GetMapping("/{id}")
    public TypeEngrais findById(@PathVariable Long id){
        return typeEngraisService.findById(id);
    }
    
    
    /**
     * 
     * @param typeEngrais
     * @return Mise a jours des elements de la table region
     */
    @PutMapping
    public TypeEngrais update(@RequestBody TypeEngrais typeEngrais) {
        return typeEngraisService.save(typeEngrais);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return chant libelle modifier
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleTypeEngrais(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleTypeEngrais = updates.get("libelle");
        Optional<TypeEngrais> updatedTypeEngrais = typeEngraisService.updateLibelleTypeEngrais(id, newLibelleTypeEngrais);
        
        if (updatedTypeEngrais.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "TypeEngrais updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    /**
     * 
     * @param id
     * @return typeEngrais supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeEngrais(@PathVariable Long id) {
        typeEngraisService.deleteTypeEngraisById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteTypeEngrais(@PathVariable Long id) {
        typeEngraisService.deleteTypeEngraisById(id);
    }
*/

}
