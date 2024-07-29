/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.RenouvellementAgrement;
import bf.agriculture.apiengrais.repositories.RenouvellementAgrementRepository;
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
public class RenouvellementAgrementService {
    
    @Autowired
    RenouvellementAgrementRepository renouvellementAgrementRepository;
    
    // sauvegarder autorisation d'Importation
    public RenouvellementAgrement save(RenouvellementAgrement renouvellementAgrement){
        return renouvellementAgrementRepository.save(renouvellementAgrement);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<RenouvellementAgrement> findAll() {
        return renouvellementAgrementRepository.findAll();
    }
    
     // Rechercher par le ID
    public RenouvellementAgrement findById(Long id) {
        return renouvellementAgrementRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la RenouvellementAgrement
//    public Optional<RenouvellementAgrement> updateLibelleRenouvellementAgrement(Long id, String newLibelleRenouvellementAgrement) {
//        Optional<RenouvellementAgrement> renouvellementAgrementOptional = renouvellementAgrementRepository.findById(id);
//        if (renouvellementAgrementOptional.isPresent()) {
//            RenouvellementAgrement renouvellementAgrement = renouvellementAgrementOptional.get();
//            renouvellementAgrement.setLibelle(newLibelleRenouvellementAgrement);
//            renouvellementAgrementRepository.save(renouvellementAgrement);
//        }
//        return renouvellementAgrementOptional;
//    }
    
    public void deleteRenouvellementAgrementById(Long id) {
        Optional<RenouvellementAgrement> renouvellementAgrement = renouvellementAgrementRepository.findById(id);
        if (renouvellementAgrement.isPresent()) {
            renouvellementAgrementRepository.delete(renouvellementAgrement.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
