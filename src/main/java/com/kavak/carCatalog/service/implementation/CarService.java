package com.kavak.carCatalog.service.implementation;

import com.kavak.carCatalog.converter.ConverterCar;
import com.kavak.carCatalog.dto.CarDto;
import com.kavak.carCatalog.model.Car;
import com.kavak.carCatalog.repository.CarRepository;
import com.kavak.carCatalog.service.InterfaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements InterfaceCarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ConverterCar converterCar;

    @Override
    public List<CarDto> listCar() {
        return converterCar.converterEntitiesToDtos(carRepository.findAll());
    }

    @Override
    public CarDto getCarById(Integer id) {
        return null;
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = converterCar.converterDtoToEntity(carDto);
        Car savedCar = carRepository.save(car);
        return converterCar.converterEntityToDto(savedCar);
    }

    @Override
    public CarDto replace(CarDto carDto, Integer id) {
        Car car = returnCarById(id).orElse(null);
        if (car != null) {
            car.setBrand(carDto.getBrand());
            car.setModel(carDto.getModel());
            car.setName(carDto.getName());
            car.setPhoto(carDto.getPhoto());
            carRepository.save(car);
            return converterCar.converterEntityToDto(car);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Car car = returnCarById(id).orElse(null);
        if (car != null) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private Optional<Car> returnCarById(Integer id) {
        return carRepository.findById(id);
    }
}
