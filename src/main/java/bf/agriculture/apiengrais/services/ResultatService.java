/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Resultat;
import bf.agriculture.apiengrais.repositories.ResultatRepository;
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
public class ResultatService {
    
    @Autowired
    ResultatRepository resultatRepository;
    
    // sauvegarder autorisation d'Importation
    public Resultat save(Resultat resultat){
        return resultatRepository.save(resultat);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<Resultat> findAll() {
        return resultatRepository.findAll();
    }
    
     // Rechercher par le ID
    public Resultat findById(Long id) {
        return resultatRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la Resultat
//    public Optional<Resultat> updateLibelleResultat(Long id, String newLibelleResultat) {
//        Optional<Resultat> resultatOptional = resultatRepository.findById(id);
//        if (resultatOptional.isPresent()) {
//            Resultat resultat = resultatOptional.get();
//            resultat.setLibelle(newLibelleResultat);
//            resultatRepository.save(resultat);
//        }
//        return resultatOptional;
//    }
    
    public void deleteResultatById(Long id) {
        Optional<Resultat> resultat = resultatRepository.findById(id);
        if (resultat.isPresent()) {
            resultatRepository.delete(resultat.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
