/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Province;
import bf.agriculture.apiengrais.services.ProvinceService;
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
@RequestMapping("/api/provinces")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    
    /**
     * 
     * @param province
     * @return ajouter une province
     */
    @PostMapping
    public Province save(@RequestBody Province province) {
        return provinceService.save(province);
    }
    
    
    /**
     * 
     * @return liste des provinces
     */
    @GetMapping
    public List<Province> findAll(){
        return provinceService.getSortedProvincesByLibelle();
    }
    
    
    /**
     * 
     * @param id
     * @return liste de provinces par id
     */
    @GetMapping("/{id}")
    public Province findById(@PathVariable Long id){
        return provinceService.findById(id);
    }
    
    
    /**
     * 
     * @param province
     * @return Mise a jours des elements de la table province
     */
    @PutMapping
    public Province update(@RequestBody Province province) {
        return provinceService.save(province);
    }
    
    
    /**
     * 
     * @param id
     * @param updates
     * @return modifier le  libelle de province
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleProvince(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleProvince = updates.get("libelle");
        Optional<Province> updatedProvince = provinceService.updateLibelleProvince(id, newLibelleProvince);
        
        if (updatedProvince.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Province updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    /**
     * 
     * @param id
     * @return province supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvinceById(id);
        return ResponseEntity.noContent().build();
    }
    
/*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvinceById(id);
    }
*/

}
