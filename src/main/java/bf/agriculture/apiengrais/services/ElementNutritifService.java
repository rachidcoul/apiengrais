/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.ElementNutritif;
import bf.agriculture.apiengrais.repositories.ElementNutritifRepository;
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
public class ElementNutritifService {
    
    @Autowired
    ElementNutritifRepository elementNutritifRepository;
    
    // sauvegarder autorisation d'Importation
    public ElementNutritif save(ElementNutritif elementNutritif){
        return elementNutritifRepository.save(elementNutritif);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<ElementNutritif> findAll() {
        return elementNutritifRepository.findAll();
    }
    
     // Rechercher par le ID
    public ElementNutritif findById(Long id) {
        return elementNutritifRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la ElementNutritif
    public Optional<ElementNutritif> updateLibelleElementNutritif(Long id, String newLibelleElementNutritif) {
        Optional<ElementNutritif> elementNutritifOptional = elementNutritifRepository.findById(id);
        if (elementNutritifOptional.isPresent()) {
            ElementNutritif elementNutritif = elementNutritifOptional.get();
            elementNutritif.setLibelle(newLibelleElementNutritif);
            elementNutritifRepository.save(elementNutritif);
        }
        return elementNutritifOptional;
    }
    
    public void deleteElementNutritifById(Long id) {
        Optional<ElementNutritif> elementNutritif = elementNutritifRepository.findById(id);
        if (elementNutritif.isPresent()) {
            elementNutritifRepository.delete(elementNutritif.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
