package com.kavak.carCatalog.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class BaseResource<T> {
    protected ResponseEntity<List<T>> answerListOfItems(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
    protected ResponseEntity<T> answerCreatedItem(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }
    protected ResponseEntity<T> answerUpdatedSuccess(T object) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(object);
    }
    protected ResponseEntity<Void> answerDeletedSuccess() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    protected ResponseEntity<Void> answerObjectNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    protected ResponseEntity<T> answerUpdateObjectNotFound(T object) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(object);
    }
}
