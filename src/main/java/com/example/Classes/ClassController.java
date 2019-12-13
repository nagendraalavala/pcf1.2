package com.example.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClassController {
    @Autowired
    private ClassService classService;



   /* @Autowired
    public ClassController(ClassService classService, RestOperations restOperations) {
        this.classService = classService;
        this.restOperations = restOperations;
    }*/

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassEntity> getAll() {
        return classService.findAll();
    }

    @PostMapping("/classadd")
    @ResponseStatus(HttpStatus.OK)
    public ClassEntity save(@RequestBody ClassEntity classEntity) {
        return classService.save(classEntity);
//


    }


    @PutMapping("/class/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ClassEntity update(@PathVariable Long id,@RequestBody ClassEntity classEntity)
    {
        ClassEntity classEntity1=classService.findById(id);
        classEntity1.setFaculty(classEntity.getFaculty());
        return classService.save(classEntity1);
    }



}
