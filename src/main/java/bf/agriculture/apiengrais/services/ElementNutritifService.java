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

    /**
     *
     * @param elementNutritif
     * @return ajouter un elementNutritif
     */
    public ElementNutritif save(ElementNutritif elementNutritif) {
        return elementNutritifRepository.save(elementNutritif);
    }

    /**
     *
     * @return liste des elementNutritifs
     */
    /*
    public List<ElementNutritif> findAll() {
        return elementNutritifRepository.findAll();
    }
    */
    
    public List<ElementNutritif> getSortedElementNutritifsByLibelle() {
        List<ElementNutritif> elementNutritifs = elementNutritifRepository.findAll();
        return ElementNutritif.sortElementNutritifsByLibelle(elementNutritifs);
    }

    /**
     *
     * @param id
     * @return liste des elementNutritif par id
     */
    public ElementNutritif findById(Long id) {
        return elementNutritifRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id
     * @param newLibelleElementNutritif
     * @return modifier le libelle de elementNutritif
     */
    public Optional<ElementNutritif> updateLibelleElementNutritif(Long id, String newLibelleElementNutritif) {
        Optional<ElementNutritif> elementNutritifOptional = elementNutritifRepository.findById(id);
        if (elementNutritifOptional.isPresent()) {
            ElementNutritif elementNutritif = elementNutritifOptional.get();
            elementNutritif.setLibelle(newLibelleElementNutritif);
            elementNutritifRepository.save(elementNutritif);
        }
        return elementNutritifOptional;
    }

    /**
     *
     * @param id suppimer un elementNutritif
     */
    public void deleteElementNutritifById(Long id) {
        Optional<ElementNutritif> elementNutritif = elementNutritifRepository.findById(id);
        if (elementNutritif.isPresent()) {
            elementNutritifRepository.delete(elementNutritif.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
