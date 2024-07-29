/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Region;
import bf.agriculture.apiengrais.repositories.RegionRepository;
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
public class RegionService {
    
    @Autowired
    RegionRepository regionRepository;
    
    // sauvegarder autorisation d'Importation
    public Region save(Region region){
        return regionRepository.save(region);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
    
     // Rechercher par le ID
    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la Region
    public Optional<Region> updateLibelleRegion(Long id, String newLibelleRegion) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        if (regionOptional.isPresent()) {
            Region region = regionOptional.get();
            region.setLibelle(newLibelleRegion);
            regionRepository.save(region);
        }
        return regionOptional;
    }
    
    public void deleteRegionById(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()) {
            regionRepository.delete(region.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
