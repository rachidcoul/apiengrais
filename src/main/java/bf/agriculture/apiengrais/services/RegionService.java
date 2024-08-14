/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Region;
import bf.agriculture.apiengrais.repositories.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Comparator;
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

    /**
     *
     * @param region
     * @return region Sauvegarder
     */
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    /**
     *
     * @return la liste des regions
     */
    public List<Region> getSortedRegionsByLibelle() {
        List<Region> regions = regionRepository.findAll();
        regions.sort(Comparator.comparing(Region::getLibelle));
        return regions;
    }

    /**
     *
     * @param id
     * @return la liste regions en fonction du id
     */
    public Region findById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id
     * @param newLibelleRegion
     * @return le champs libelle region est modifier
     */
    public Optional<Region> updateLibelleRegion(Long id, String newLibelleRegion) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        if (regionOptional.isPresent()) {
            Region region = regionOptional.get();
            region.setLibelle(newLibelleRegion);
            regionRepository.save(region);
        }
        return regionOptional;
    }

    /**
     * @param id la supression de la region a travers le id
     */
    public void deleteRegionById(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()) {
            regionRepository.delete(region.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
