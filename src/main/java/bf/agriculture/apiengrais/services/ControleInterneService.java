/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.ControleInterne;
import bf.agriculture.apiengrais.repositories.ControleInterneRepository;
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
public class ControleInterneService {
    
    @Autowired
    ControleInterneRepository controleInterneRepository;
    
    // sauvegarder autorisation d'Importation
    public ControleInterne save(ControleInterne controleInterne){
        return controleInterneRepository.save(controleInterne);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<ControleInterne> findAll() {
        return controleInterneRepository.findAll();
    }
    
     // Rechercher par le ID
    public ControleInterne findById(Long id) {
        return controleInterneRepository.findById(id).orElse(null);
    }
    
        
    public void deleteControleInterneById(Long id) {
        Optional<ControleInterne> controleInterne = controleInterneRepository.findById(id);
        if (controleInterne.isPresent()) {
            controleInterneRepository.delete(controleInterne.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
