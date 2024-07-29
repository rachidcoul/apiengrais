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
    
    // sauvegarder autorisation d'Importation
    public Echantillon save(Echantillon echantillon){
        return echantillonRepository.save(echantillon);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<Echantillon> findAll() {
        return echantillonRepository.findAll();
    }
    
     // Rechercher par le ID
    public Echantillon findById(Long id) {
        return echantillonRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la Echantillon
//    public Optional<Echantillon> updateLibelleEchantillon(Long id, String newLibelleEchantillon) {
//        Optional<Echantillon> echantillonOptional = echantillonRepository.findById(id);
//        if (echantillonOptional.isPresent()) {
//            Echantillon echantillon = echantillonOptional.get();
//            echantillon.setLibelle(newLibelleEchantillon);
//            echantillonRepository.save(echantillon);
//        }
//        return echantillonOptional;
//    }
    
    public void deleteEchantillonById(Long id) {
        Optional<Echantillon> echantillon = echantillonRepository.findById(id);
        if (echantillon.isPresent()) {
            echantillonRepository.delete(echantillon.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
