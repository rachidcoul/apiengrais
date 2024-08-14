/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bf.agriculture.apiengrais.services;

import bf.agriculture.apiengrais.entites.Province;
import bf.agriculture.apiengrais.repositories.ProvinceRepository;
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
public class ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    /**
     *
     * @param province
     * @return sauvegarder la province
     */
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

    /**
     *
     * @return la liste des provinces
     */
    public List<Province> getSortedProvincesByLibelle() {
        List<Province> provinces = provinceRepository.findAll();
        provinces.sort(Comparator.comparing(Province::getLibelle));
        return provinces;
    }

    /**
     *
     * @param id
     * @return la liste des province en fonction du id
     */
    public Province findById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    /**
     *
     * @param id
     * @param newLibelleProvince
     * @return modifier libelle de la province
     */
    public Optional<Province> updateLibelleProvince(Long id, String newLibelleProvince) {
        Optional<Province> provinceOptional = provinceRepository.findById(id);
        if (provinceOptional.isPresent()) {
            Province province = provinceOptional.get();
            province.setLibelle(newLibelleProvince);
            provinceRepository.save(province);
        }
        return provinceOptional;
    }

    /**
     *
     * @param id suppression de la province en fonction du id
     */
    public void deleteProvinceById(Long id) {
        Optional<Province> province = provinceRepository.findById(id);
        if (province.isPresent()) {
            provinceRepository.delete(province.get());
        } else {
            throw new EntityNotFoundException("Province not found with id " + id);
        }
    }
}
