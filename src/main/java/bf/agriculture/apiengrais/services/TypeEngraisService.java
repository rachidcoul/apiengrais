/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.TypeEngrais;
import bf.agriculture.apiengrais.repositories.TypeEngraisRepository;
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
public class TypeEngraisService {
    
    @Autowired
    TypeEngraisRepository typeEngraisRepository;
    
    // sauvegarder autorisation d'Importation
    public TypeEngrais save(TypeEngrais typeEngrais){
        return typeEngraisRepository.save(typeEngrais);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<TypeEngrais> findAll() {
        return typeEngraisRepository.findAll();
    }
    
     // Rechercher par le ID
    public TypeEngrais findById(Long id) {
        return typeEngraisRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la TypeEngrais
    public Optional<TypeEngrais> updateLibelleTypeEngrais(Long id, String newLibelleTypeEngrais) {
        Optional<TypeEngrais> typeEngraisOptional = typeEngraisRepository.findById(id);
        if (typeEngraisOptional.isPresent()) {
            TypeEngrais typeEngrais = typeEngraisOptional.get();
            typeEngrais.setLibelle(newLibelleTypeEngrais);
            typeEngraisRepository.save(typeEngrais);
        }
        return typeEngraisOptional;
    }
    
    public void deleteTypeEngraisById(Long id) {
        Optional<TypeEngrais> typeEngrais = typeEngraisRepository.findById(id);
        if (typeEngrais.isPresent()) {
            typeEngraisRepository.delete(typeEngrais.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
