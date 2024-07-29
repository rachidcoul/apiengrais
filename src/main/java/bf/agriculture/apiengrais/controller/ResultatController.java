/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Resultat;
import bf.agriculture.apiengrais.services.ResultatService;
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
@RequestMapping("/api/resultat")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class ResultatController {

    @Autowired
    private ResultatService resultatService;

    /**
     *
     * @param resultat
     * @return ajouter un resultat
     */
    @PostMapping
    public Resultat save(@RequestBody Resultat resultat) {
        return resultatService.save(resultat);
    }

    /**
     *
     * @return liste des resultats
     */
    @GetMapping
    public List<Resultat> findAll() {
        return resultatService.findAll();
    }

    /**
     *
     * @param id
     * @return liste des resultat par id
     */
    @GetMapping("/{id}")
    public Resultat findById(@PathVariable Long id) {
        return resultatService.findById(id);
    }

    /**
     *
     * @param resultat
     * @return modifier les resultats
     */
    @PutMapping
    public Resultat update(@RequestBody Resultat resultat) {
        return resultatService.save(resultat);
    }

    /**
     *
     * @param id
     * @return resultat supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultat(@PathVariable Long id) {
        resultatService.deleteResultatById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteResultat(@PathVariable Long id) {
        resultatService.deleteResultatById(id);
    }
     */
}
