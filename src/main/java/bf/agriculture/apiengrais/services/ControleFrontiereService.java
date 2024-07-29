/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.ControleFrontiere;
import bf.agriculture.apiengrais.repositories.ControleFrontiereRepository;
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
public class ControleFrontiereService {
    
    @Autowired
    ControleFrontiereRepository controleFrontiereRepository;
    
    // sauvegarder autorisation d'Importation
    public ControleFrontiere save(ControleFrontiere autorisationImportation){
        return controleFrontiereRepository.save(autorisationImportation);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<ControleFrontiere> findAll() {
        return controleFrontiereRepository.findAll();
    }
    
     // Rechercher par le ID
    public ControleFrontiere findById(Long id) {
        return controleFrontiereRepository.findById(id).orElse(null);
    }
    
        
    public void deleteControleFrontiereById(Long id) {
        Optional<ControleFrontiere> autorisationImportation = controleFrontiereRepository.findById(id);
        if (autorisationImportation.isPresent()) {
            controleFrontiereRepository.delete(autorisationImportation.get());
        } else {
            throw new EntityNotFoundException("ControleFrontiere not found with id " + id);
        }
    }
}
