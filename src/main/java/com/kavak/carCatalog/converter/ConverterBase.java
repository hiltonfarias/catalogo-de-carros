package com.kavak.carCatalog.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<E, D> {

    public abstract D converterEntityToDto(E entity);

    public abstract E converterDtoToEntity(D dto);

    public List<D> converterEntitiesToDtos(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(converterEntityToDto(entity)));
        return dtos;
    }

    public List<E> converterDtosToEntities(List<D> dtos) {
        List<E> listEntities = new ArrayList<>();
        dtos.stream().forEach(dto->listEntities.add(converterDtoToEntity(dto)));
        return listEntities;
    }
}
