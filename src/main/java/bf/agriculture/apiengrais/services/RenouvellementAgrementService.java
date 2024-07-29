/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.RenouvellementAgrement;
import bf.agriculture.apiengrais.repositories.RenouvellementAgrementRepository;
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
public class RenouvellementAgrementService {

    @Autowired
    RenouvellementAgrementRepository renouvellementAgrementRepository;

    /**
     *
     * @param renouvellementAgrement
     * @return ajouter un renouvellementagrement
     */
    public RenouvellementAgrement save(RenouvellementAgrement renouvellementAgrement) {
        return renouvellementAgrementRepository.save(renouvellementAgrement);
    }

    /**
     *
     * @return liste des renouvellements
     */
    public List<RenouvellementAgrement> findAll() {
        return renouvellementAgrementRepository.findAll();
    }

    /**
     *
     * @param id
     * @return liste des renouvellement par id
     */
    public RenouvellementAgrement findById(Long id) {
        return renouvellementAgrementRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id suppression d'un renouvellement
     */
    public void deleteRenouvellementAgrementById(Long id) {
        Optional<RenouvellementAgrement> renouvellementAgrement = renouvellementAgrementRepository.findById(id);
        if (renouvellementAgrement.isPresent()) {
            renouvellementAgrementRepository.delete(renouvellementAgrement.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
