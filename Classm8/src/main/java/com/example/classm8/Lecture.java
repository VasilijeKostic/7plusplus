package com.example.classm8;

public class Lecture {
    private String lectureName;

    public Lecture(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    @Override
    public String toString() {
        return "Lecture name: " + lectureName;
    }
}
