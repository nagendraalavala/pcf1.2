package com.example.Classes;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ClassEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String faculty;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public ClassEntity(Long id, String faculty) {
        Id = id;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "Id=" + Id +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
