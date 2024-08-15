/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Region;
import bf.agriculture.apiengrais.services.RegionService;
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
@RequestMapping("/api/regions")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class RegionController {

    @Autowired
    private RegionService regionService;

    /**
     *
     * @param region
     * @return ajouter une region
     */
    @PostMapping
    public Region save(@RequestBody Region region) {
        return regionService.save(region);
    }

    /**
     *
     * @return liste des region
     */
    @GetMapping
    public List<Region> findAll() {
        return regionService.getSortedRegionsByLibelle();
    }

    /**
     *
     * @param id
     * @return liste de region par id
     */
    @GetMapping("/{id}")
    public Region findById(@PathVariable Long id) {
        return regionService.findById(id);
    }

    /**
     *
     * @param region
     * @return Mise a jours des elements de la table region
     */
    @PostMapping("/{id}")
    public Region update(@RequestBody Region region) {
        return regionService.save(region);
    }

    /**
     *
     * @param id
     * @param updates
     * @return modifier le libelle region
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateLibelleRegion(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        String newLibelleRegion = updates.get("libelle");
        Optional<Region> updatedRegion = regionService.updateLibelleRegion(id, newLibelleRegion);

        if (updatedRegion.isPresent()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Region updated successfully");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     *
     * @param id
     * @return region supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionService.deleteRegionById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegionById(id);
    }
     */
}
