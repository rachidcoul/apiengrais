/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bf.agriculture.apiengrais.repositories;

import bf.agriculture.apiengrais.entites.Province;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author car
 */
public interface ProvinceRepository extends JpaRepository <Province, Long> {
    
}
