package com.greenfox.csomam.orientationexam.repositories;

import com.greenfox.csomam.orientationexam.modules.LicencePlate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicencePlateRepo extends CrudRepository<LicencePlate, Long> {

    @Query(value = "SELECT * FROM licence_plates WHERE plate LIKE %?1%", nativeQuery = true)
    List<LicencePlate> findLicencePlate (String plateNum);

    @Query(value = "SELECT * FROM licence_plates WHERE plate LIKE ?1%", nativeQuery = true)
    List<LicencePlate> findLicenceType (String plateNum);

    @Query(value = "SELECT * FROM licence_plates WHERE car_brand LIKE ?1", nativeQuery = true)
    List<LicencePlate> findBrand (String brand);
}
