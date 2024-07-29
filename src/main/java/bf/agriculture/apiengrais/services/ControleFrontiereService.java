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
    
    /**
     * 
     * @param controleFrontiere
     * @return ajouter un controleFrontiere
     */
    public ControleFrontiere save(ControleFrontiere controleFrontiere){
        return controleFrontiereRepository.save(controleFrontiere);
    }
    
    /**
     * 
     * @return 
     * liste des controleFrontiere
     */
    public List<ControleFrontiere> findAll() {
        return controleFrontiereRepository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return liste des controleFrontiere par id
     */
    public ControleFrontiere findById(Long id) {
        return controleFrontiereRepository.findById(id).orElse(null);
    }
    
    /**
     * 
     * @param id 
     * supprimer un controleFrontiere
     */    
    public void deleteControleFrontiereById(Long id) {
        Optional<ControleFrontiere> controleFrontiere = controleFrontiereRepository.findById(id);
        if (controleFrontiere.isPresent()) {
            controleFrontiereRepository.delete(controleFrontiere.get());
        } else {
            throw new EntityNotFoundException("ControleFrontiere not found with id " + id);
        }
    }
}
