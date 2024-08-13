/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.ControleInterne;
import bf.agriculture.apiengrais.entites.Region;
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
    
    /**
     * 
     * @param controleInterne
     * @return ajouter un controleInterne
     */
    public ControleInterne save(ControleInterne controleInterne){
        return controleInterneRepository.save(controleInterne);
    }
    
    /**
     * 
     * @return lister les controleInternes
     */
    /*
    public List<ControleInterne> findAll() {
        return controleInterneRepository.findAll();
    }
    */
    public List<ControleInterne> getSortedControleInternesByDateControle() {
        List<ControleInterne> controleInternes = controleInterneRepository.findAll();
        return ControleInterne.sortControleInternesByDateControle(controleInternes);
    }
    
    /**
     * 
     * @param id
     * @return lister un controleInterne par id
     */
    public ControleInterne findById(Long id) {
        return controleInterneRepository.findById(id).orElse(null);
    }
    
    /**
     * 
     * @param id 
     * supprimer un controleInterne
     */   
    public void deleteControleInterneById(Long id) {
        Optional<ControleInterne> controleInterne = controleInterneRepository.findById(id);
        if (controleInterne.isPresent()) {
            controleInterneRepository.delete(controleInterne.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
