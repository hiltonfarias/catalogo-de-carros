package com.kavak.carCatalog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class CarDto {

    private Integer id;

    private String name;

    private String brand;

    private String model;

    private String photo;
}
