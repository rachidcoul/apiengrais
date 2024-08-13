/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.AutorisationImportation;
import bf.agriculture.apiengrais.repositories.AutorisationImportationRepository;
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
public class AutorisationImportationService {

    @Autowired
    AutorisationImportationRepository autorisationImportationRepository;

    /**
     *
     * @param autorisationImportation
     * @return ajouter une autorisation d'importation
     */
    public AutorisationImportation save(AutorisationImportation autorisationImportation) {
        return autorisationImportationRepository.save(autorisationImportation);
    }

    /**
     *
     * @return liste des autorisations d'importation
     */
    /*
    public List<AutorisationImportation> findAll() {
        return autorisationImportationRepository.findAll();
    }
    */
    
    public List<AutorisationImportation> getSortedAutorisationImportationByNumero() {
        List<AutorisationImportation> autorisationImportations = autorisationImportationRepository.findAll();
        return AutorisationImportation.sortAutorisationImportationsByNumero(autorisationImportations);
    }

    /**
     *
     * @param id
     * @return tous les autorisations d'importation par id
     */
    public AutorisationImportation findById(Long id) {
        return autorisationImportationRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id
     * @param newLibelleAutorisationImportation
     * @return modifier le libelle
     */
    public Optional<AutorisationImportation> updateLibelleAutorisationImportation(Long id, String newLibelleAutorisationImportation) {
        Optional<AutorisationImportation> autorisationImportationOptional = autorisationImportationRepository.findById(id);
        if (autorisationImportationOptional.isPresent()) {
            AutorisationImportation autorisationImportation = autorisationImportationOptional.get();
            autorisationImportation.setLibelle(newLibelleAutorisationImportation);
            autorisationImportationRepository.save(autorisationImportation);
        }
        return autorisationImportationOptional;
    }

    /**
     * 
     * @param id 
     * suppression d'une autorisations d'importation
     */
    public void deleteAutorisationImportationById(Long id) {
        Optional<AutorisationImportation> autorisationImportation = autorisationImportationRepository.findById(id);
        if (autorisationImportation.isPresent()) {
            autorisationImportationRepository.delete(autorisationImportation.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }

}
