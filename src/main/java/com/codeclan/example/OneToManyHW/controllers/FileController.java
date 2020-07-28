package com.codeclan.example.OneToManyHW.controllers;

import com.codeclan.example.OneToManyHW.models.File;
import com.codeclan.example.OneToManyHW.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value="/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/files/{id}")
    public ResponseEntity getFiles(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/files")
    public ResponseEntity<File> postFiles(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity(file, HttpStatus.OK);
    }

}
