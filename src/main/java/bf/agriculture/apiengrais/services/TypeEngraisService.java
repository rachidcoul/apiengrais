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
    
    /**
     * 
     * @param typeEngrais
     * @return ajouter un typeEngrais
     */
    public TypeEngrais save(TypeEngrais typeEngrais){
        return typeEngraisRepository.save(typeEngrais);
    }
    
    /**
     * 
     * @return 
     * lister les typeEngrais
     */
    /*
    public List<TypeEngrais> findAll() {
        return typeEngraisRepository.findAll();
    }
    */
    
    public List<TypeEngrais> getSortedTypeEngraissByLibelle() {
        List<TypeEngrais> typeEngraiss = typeEngraisRepository.findAll();
        return TypeEngrais.sortTypeEngraissByLibelle(typeEngraiss);
    }
    
    /**
     * 
     * @param id
     * @return lister le typeEngrais par id
     */
    
    public TypeEngrais findById(Long id) {
        return typeEngraisRepository.findById(id).orElse(null);
    }
    
    /**
     * 
     * @param id
     * @param newLibelleTypeEngrais
     * @return modifier le libelle de typeEngrais
     */
    public Optional<TypeEngrais> updateLibelleTypeEngrais(Long id, String newLibelleTypeEngrais) {
        Optional<TypeEngrais> typeEngraisOptional = typeEngraisRepository.findById(id);
        if (typeEngraisOptional.isPresent()) {
            TypeEngrais typeEngrais = typeEngraisOptional.get();
            typeEngrais.setLibelle(newLibelleTypeEngrais);
            typeEngraisRepository.save(typeEngrais);
        }
        return typeEngraisOptional;
    }
    
    /**
     * 
     * @param id 
     * supprimer un typeEngrais
     */
    public void deleteTypeEngraisById(Long id) {
        Optional<TypeEngrais> typeEngrais = typeEngraisRepository.findById(id);
        if (typeEngrais.isPresent()) {
            typeEngraisRepository.delete(typeEngrais.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
