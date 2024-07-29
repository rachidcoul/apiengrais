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
    
    /**
     * 
     * @param requerant
     * @return ajouter un requerant
     */
    public Requerant save(Requerant requerant){
        return requerantRepository.save(requerant);
    }
    
    /**
     * 
     * @return liste des requerants
     */
    public List<Requerant> findAll() {
        return requerantRepository.findAll();
    }
    
     // Rechercher par le ID
    public Requerant findById(Long id) {
        return requerantRepository.findById(id).orElse(null);
    }
    
    /**
     * 
     * @param id
     * @param newNomPrenomRequerant
     * @return modification du Nom Prenom de requetant
     */
    public Optional<Requerant> updateNomPrenomRequerant(Long id, String newNomPrenomRequerant) {
        Optional<Requerant> requerantOptional = requerantRepository.findById(id);
        if (requerantOptional.isPresent()) {
            Requerant requerant = requerantOptional.get();
            requerant.setNomPrenom(newNomPrenomRequerant);
            requerantRepository.save(requerant);
        }
        return requerantOptional;
    }
    
    /**
     * 
     * @param id
     * @param newContactRequerant
     * @return modification du contacte de requerant
     */
    public Optional<Requerant> updateContactRequerant(Long id, String newContactRequerant) {
        Optional<Requerant> requerantOptional = requerantRepository.findById(id);
        if (requerantOptional.isPresent()) {
            Requerant requerant = requerantOptional.get();
            requerant.setContact(newContactRequerant);
            requerantRepository.save(requerant);
        }
        return requerantOptional;
    }
    
    /**
     * 
     * @param id
     * @param newEmailRequerant
     * @return modification du email
     */
    public Optional<Requerant> updateEmailRequerant(Long id, String newEmailRequerant) {
        Optional<Requerant> requerantOptional = requerantRepository.findById(id);
        if (requerantOptional.isPresent()) {
            Requerant requerant = requerantOptional.get();
            requerant.setEmail(newEmailRequerant);
            requerantRepository.save(requerant);
        }
        return requerantOptional;
    }
    
    /**
     * 
     * @param id 
     * suppression du requerant par id
     */
    public void deleteRequerantById(Long id) {
        Optional<Requerant> requerant = requerantRepository.findById(id);
        if (requerant.isPresent()) {
            requerantRepository.delete(requerant.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
