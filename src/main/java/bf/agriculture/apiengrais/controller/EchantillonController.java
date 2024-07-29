/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.controller;

import bf.agriculture.apiengrais.entites.Echantillon;
import bf.agriculture.apiengrais.services.EchantillonService;
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
@RequestMapping("/api/echantillon")
@CrossOrigin("*")//pour permettre au front de d'acceder aux donnees du restcontroller
public class EchantillonController {

    @Autowired
    private EchantillonService echantillonService;

    /**
     *
     * @param echantillon
     * @return echantillons ajouter
     */
    @PostMapping
    public Echantillon save(@RequestBody Echantillon echantillon) {
        return echantillonService.save(echantillon);
    }

    /**
     *
     * @return liste des echantillons
     */
    @GetMapping
    public List<Echantillon> findAll() {
        return echantillonService.findAll();
    }

    /**
     *
     * @param id
     * @return liste d'un echantillon par id
     */
    @GetMapping("/{id}")
    public Echantillon findById(@PathVariable Long id) {
        return echantillonService.findById(id);
    }

    /**
     *
     * @param echantillon
     * @return Mise a jours des elements d'un echantillon
     */
    @PutMapping
    public Echantillon update(@RequestBody Echantillon echantillon) {
        return echantillonService.save(echantillon);
    }

   
    /**
     *
     * @param id
     * @return echantillon supprimer avec message de confirmation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEchantillon(@PathVariable Long id) {
        echantillonService.deleteEchantillonById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    //Supression simple avec appel de fonction depuis le region service
    @DeleteMapping("/{id}")
    public void deleteEchantillon(@PathVariable Long id) {
        echantillonService.deleteEchantillonById(id);
    }
     */
}
