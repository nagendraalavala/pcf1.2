package com.example.Classes;

import java.io.Serializable;

public class CourseEntity implements Serializable
{
    private Long id;
    private String courseName;
    private String faculty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public CourseEntity(Long id, String courseName, String faculty) {
        this.id = id;
        this.courseName = courseName;
        this.faculty = faculty;
    }
    public CourseEntity()
    {}
}
