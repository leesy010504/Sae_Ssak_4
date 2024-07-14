package com.example.crops;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CropsRepository extends JpaRepository<Crops, Integer> {
    Optional<Crops> findByCropName(String cropName);


}
