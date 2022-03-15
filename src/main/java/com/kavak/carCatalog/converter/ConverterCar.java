package com.kavak.carCatalog.converter;

import com.kavak.carCatalog.dto.CarDto;
import com.kavak.carCatalog.model.Car;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class ConverterCar extends ConverterBase<Car, CarDto> {

    @Override
    public CarDto converterEntityToDto(Car entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Car, CarDto>() {
            @Override
            protected void configure() {

            }
        });
        return modelMapper.map(entity, CarDto.class);
    }

    @Override
    public Car converterDtoToEntity(CarDto dto) {
        return Car.builder()
                .brand(dto.getBrand())
                .name(dto.getName())
                .model(dto.getModel())
                .photo(dto.getPhoto())
                .build();
    }
}
