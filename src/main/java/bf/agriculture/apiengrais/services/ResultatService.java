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

    /**
     *
     * @param resultat
     * @return ajouter un resultat
     */
    public Resultat save(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    /**
     *
     * @return lister des resultats
     */
    public List<Resultat> findAll() {
        return resultatRepository.findAll();
    }

    /**
     *
     * @param id
     * @return liste de resultat apr id
     */
    public Resultat findById(Long id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public void deleteResultatById(Long id) {
        Optional<Resultat> resultat = resultatRepository.findById(id);
        if (resultat.isPresent()) {
            resultatRepository.delete(resultat.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
