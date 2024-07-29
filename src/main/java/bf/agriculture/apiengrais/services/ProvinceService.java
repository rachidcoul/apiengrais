/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Province;
import bf.agriculture.apiengrais.repositories.ProvinceRepository;
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
public class ProvinceService {
    
    @Autowired
    ProvinceRepository provinceRepository;
    
    // sauvegarder autorisation d'Importation
    public Province save(Province province){
        return provinceRepository.save(province);
    }
    
    //operation de recherche sur tous les elements de la region
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
    
     // Rechercher par le ID
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }
    
    //pour faire la mise a jours d'un seul element: le libelle de la Province
    public Optional<Province> updateLibelleProvince(Long id, String newLibelleProvince) {
        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (provinceOptional.isPresent()) {
            Province province = provinceOptional.get();
            province.setLibelle(newLibelleProvince);
            provinceRepository.save(province);
        }
        return provinceOptional;
    }
    
    public void deleteProvinceById(Long id) {
        Optional<Province> province = provinceRepository.findById(id);
        if (province.isPresent()) {
            provinceRepository.delete(province.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
