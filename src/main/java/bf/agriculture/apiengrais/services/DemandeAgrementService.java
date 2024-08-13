/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.DemandeAgrement;
import bf.agriculture.apiengrais.repositories.DemandeAgrementRepository;
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
public class DemandeAgrementService {

    @Autowired
    DemandeAgrementRepository demandeAgrementRepository;

    /**
     *
     * @param demandeAgrement
     * @return ajouter une demande d'agrements
     */
    public DemandeAgrement save(DemandeAgrement demandeAgrement) {
        return demandeAgrementRepository.save(demandeAgrement);
    }

    /**
     *
     * @return liste des demandes agresments
     */
    /*
    public List<DemandeAgrement> findAll() {
        return demandeAgrementRepository.findAll();
    }
    */
    
    public List<DemandeAgrement> getSortedAgrementsByCodeAgrement() {
        List<DemandeAgrement> demandeAgrements = demandeAgrementRepository.findAll();
        return DemandeAgrement.sortDemandeAgrementsByCodeAgrement(demandeAgrements);
    }

    /**
     *
     * @param id
     * @return demande agrement par id
     */
    public DemandeAgrement findById(Long id) {
        return demandeAgrementRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id
     * @param newNumRccmDemandeAgrement
     * @return modofier le numero RCCM
     */
    public Optional<DemandeAgrement> updateNumRccmDemandeAgrement(Long id, String newNumRccmDemandeAgrement) {
        Optional<DemandeAgrement> demandeAgrementOptional = demandeAgrementRepository.findById(id);
        if (demandeAgrementOptional.isPresent()) {
            DemandeAgrement demandeAgrement = demandeAgrementOptional.get();
            demandeAgrement.setNumRccm(newNumRccmDemandeAgrement);
            demandeAgrementRepository.save(demandeAgrement);
        }
        return demandeAgrementOptional;
    }

    /**
     *
     * @param id
     * @param newActiviteDemandeAgrement
     * @return modifier activite de demande agrement
     */
    public Optional<DemandeAgrement> updateActiviteDemandeAgrement(Long id, String newActiviteDemandeAgrement) {
        Optional<DemandeAgrement> demandeAgrementOptional = demandeAgrementRepository.findById(id);
        if (demandeAgrementOptional.isPresent()) {
            DemandeAgrement demandeAgrement = demandeAgrementOptional.get();
            demandeAgrement.setActivite(newActiviteDemandeAgrement);
            demandeAgrementRepository.save(demandeAgrement);
        }
        return demandeAgrementOptional;
    }

    /**
     *
     * @param id
     * @param newNumIfuDemandeAgrement
     * @return modifier le numero ifu
     */
    public Optional<DemandeAgrement> updateNumIfuDemandeAgrement(Long id, String newNumIfuDemandeAgrement) {
        Optional<DemandeAgrement> demandeAgrementOptional = demandeAgrementRepository.findById(id);
        if (demandeAgrementOptional.isPresent()) {
            DemandeAgrement demandeAgrement = demandeAgrementOptional.get();
            demandeAgrement.setNumIfu(newNumIfuDemandeAgrement);
            demandeAgrementRepository.save(demandeAgrement);
        }
        return demandeAgrementOptional;
    }

    /**
     *
     * @param id suppression de la demande d'agrement
     */
    public void deleteDemandeAgrementById(Long id) {
        Optional<DemandeAgrement> demandeAgrement = demandeAgrementRepository.findById(id);
        if (demandeAgrement.isPresent()) {
            demandeAgrementRepository.delete(demandeAgrement.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
