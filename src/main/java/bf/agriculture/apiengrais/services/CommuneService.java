/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Commune;
import bf.agriculture.apiengrais.repositories.CommuneRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author car
 */
@Service
public class CommuneService {

    @Autowired
    CommuneRepository communeRepository;

    // sauvegarder autorisation d'Importation
    public Commune save(Commune commune) {
        return communeRepository.save(commune);
    }

    //operation de recherche sur tous les elements de la region
    public List<Commune> findAll() {
        return communeRepository.findAll();
    }

    // Rechercher par le ID
    public Commune findById(Long id) {
        return communeRepository.findById(id).orElse(null);
    }

    
    
    /**
     * 
     * @param id
     * @param newLibelleCommune
     * @return metre a jours le libelle de la Commune
     */
    /* methode de SOME
    public Commune updateLibelleCommune(Long id, String newLibelleCommune) {
        Commune commune = communeRepository.findById(id).orElse(null);

        if (commune != null) {
            commune.setLibelle(newLibelleCommune);
            communeRepository.save(commune);
        }
        return commune;
    }
    */

    /**
     * 
     * @param id
     * @param newLibelleCommune
     * @return modification du libelle de la commune
     */
     public Optional<Commune> updateLibelleCommune(Long id, String newLibelleCommune) {
        Optional<Commune> communeOptional = communeRepository.findById(id);
        if (communeOptional.isPresent()) {
            Commune commune = communeOptional.get();
            commune.setLibelle(newLibelleCommune);
            communeRepository.save(commune);
        }
        return communeOptional;
    }
     
    /**
     * methode de suppression de la commune par id
     * @param id 
     */ 
    public void deleteCommuneById(Long id) {
        Optional<Commune> commune = communeRepository.findById(id);
        if (commune.isPresent()) {
            communeRepository.delete(commune.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
