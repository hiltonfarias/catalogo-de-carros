package com.kavak.carCatalog.service;

import com.kavak.carCatalog.dto.CarDto;

import java.util.List;

public interface InterfaceCarService {
    List<CarDto> listCar();
    CarDto getCarById(Integer id);
    CarDto save(CarDto carDto);
    CarDto replace(CarDto carDto, Integer id);
    boolean delete(Integer id);
}
