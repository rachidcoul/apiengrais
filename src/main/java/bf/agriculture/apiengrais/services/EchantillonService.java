/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Echantillon;
import bf.agriculture.apiengrais.repositories.EchantillonRepository;
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
public class EchantillonService {
    
    @Autowired
    EchantillonRepository echantillonRepository;
    
    /**
     * 
     * @param echantillon
     * @return ajouter un echantillon
     */
    public Echantillon save(Echantillon echantillon){
        return echantillonRepository.save(echantillon);
    }
    
    /**
     * 
     * @return lister les echantillons
     */
    public List<Echantillon> findAll() {
        return echantillonRepository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return liste d'un echantillon par id
     */
    public Echantillon findById(Long id) {
        return echantillonRepository.findById(id).orElse(null);
    }
    
    /**
     * 
     * @param id 
     * supprimer un echantillon par id
     */
    public void deleteEchantillonById(Long id) {
        Optional<Echantillon> echantillon = echantillonRepository.findById(id);
        if (echantillon.isPresent()) {
            echantillonRepository.delete(echantillon.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
