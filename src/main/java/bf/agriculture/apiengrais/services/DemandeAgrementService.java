/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.DemandeAgrement;
import bf.agriculture.apiengrais.repositories.DemandeAgrementRepository;
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
public class DemandeAgrementService {
    
    @Autowired
    DemandeAgrementRepository demandeAgrementRepository;
    
    // sauvegarder autorisation d'Importation
    public DemandeAgrement save(DemandeAgrement demandeAgrement){
        return demandeAgrementRepository.save(demandeAgrement);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<DemandeAgrement> findAll() {
        return demandeAgrementRepository.findAll();
    }
    
     // Rechercher par le ID
    public DemandeAgrement findById(Long id) {
        return demandeAgrementRepository.findById(id).orElse(null);
    }
    
    
    //pour faire la mise a jours d'un seul element: le libelle de la DemandeAgrement
    public Optional<DemandeAgrement> updateActiviteDemandeAgrement(Long id, String newActiviteDemandeAgrement) {
        Optional<DemandeAgrement> demandeAgrementOptional = demandeAgrementRepository.findById(id);
        if (demandeAgrementOptional.isPresent()) {
            DemandeAgrement demandeAgrement = demandeAgrementOptional.get();
            demandeAgrement.setActivite(newActiviteDemandeAgrement);
            demandeAgrementRepository.save(demandeAgrement);
        }
        return demandeAgrementOptional;
    }

    
    public void deleteDemandeAgrementById(Long id) {
        Optional<DemandeAgrement> demandeAgrement = demandeAgrementRepository.findById(id);
        if (demandeAgrement.isPresent()) {
            demandeAgrementRepository.delete(demandeAgrement.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
