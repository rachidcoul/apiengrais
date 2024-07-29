/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Requerant;
import bf.agriculture.apiengrais.repositories.RequerantRepository;
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
public class RequerantService {
    
    @Autowired
    RequerantRepository requerantRepository;
    
    // sauvegarder autorisation d'Importation
    public Requerant save(Requerant requerant){
        return requerantRepository.save(requerant);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<Requerant> findAll() {
        return requerantRepository.findAll();
    }
    
     // Rechercher par le ID
    public Requerant findById(Long id) {
        return requerantRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la Requerant
    public Optional<Requerant> updateNomPrenomRequerant(Long id, String newNomPrenomRequerant) {
        Optional<Requerant> requerantOptional = requerantRepository.findById(id);
        if (requerantOptional.isPresent()) {
            Requerant requerant = requerantOptional.get();
            requerant.setNomPrenom(newNomPrenomRequerant);
            requerantRepository.save(requerant);
        }
        return requerantOptional;
    }
    
    public void deleteRequerantById(Long id) {
        Optional<Requerant> requerant = requerantRepository.findById(id);
        if (requerant.isPresent()) {
            requerantRepository.delete(requerant.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
