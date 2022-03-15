package com.kavak.carCatalog.resource;

import com.kavak.carCatalog.dto.CarDto;
import com.kavak.carCatalog.service.InterfaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarResource extends BaseResource<CarDto> {

    @Autowired
    private InterfaceCarService interfaceCarService;

    @GetMapping
    public ResponseEntity<List<CarDto>> list() {
        return answerListOfItems(interfaceCarService.listCar());
    }

    @PostMapping
    public ResponseEntity<CarDto> create(@RequestBody CarDto carDto) {
        return answerCreatedItem(interfaceCarService.save(carDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@RequestBody CarDto carDto, @PathVariable Integer id){
        CarDto replace = interfaceCarService.replace(carDto, id);
        if (replace != null) return answerUpdatedSuccess(replace);
        return answerUpdateObjectNotFound(replace);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (interfaceCarService.delete(id)) return answerDeletedSuccess();
        return answerObjectNotFound();
    }
}
