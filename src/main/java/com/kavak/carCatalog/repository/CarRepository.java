package com.kavak.carCatalog.repository;

import com.kavak.carCatalog.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
