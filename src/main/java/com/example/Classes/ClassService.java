package com.example.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService
{

    private ClassInter repo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public ClassService(ClassInter repo) {
        this.repo = repo;
    }

    //save
    public ClassEntity save(ClassEntity classEntity)
    {
        final ResponseEntity<CourseEntity> response = restTemplate.exchange("http://localhost:8089/course/" + classEntity.getFaculty(),
                HttpMethod.GET,null,
                CourseEntity.class);
        if(response.getBody()!=null&&response.getBody().getFaculty()!=null)
        {
            return repo.save(classEntity);

        }
        else {
            throw new RuntimeException("Invalid");
        }



    }

                //restTemplate.getForObject("localhost:8089/course/"+classEntity.getFaculty(),)



    //findall
    public List<ClassEntity> findAll()
    {
        return (List<ClassEntity>) repo.findAll();
    }

    //delete
    public void delete(ClassEntity classEntity)
    {
         repo.delete(classEntity);
    }

    public ClassEntity findById(Long id)
    {

        Optional<ClassEntity> classEntity1= repo.findById(id);
        if(classEntity1.isPresent())
        {
            return classEntity1.get();
        }
        else {
            return null;
        }
    }

}
