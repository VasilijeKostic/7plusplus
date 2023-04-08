package com.example.classm8;

import java.util.List;

public class User {
    private String username, name, surname;
    int age;

    public User(String username, String name, String surname, int age) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.age = user.getAge();
    }

    public User() {
        this.username = null;
        this.name = null;
        this.surname = null;
        this.age = 0;
    }

    public int getAge() {
        return age;
    }


    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User matchUser(List<User> users) {
        User bestUser = null;
        int bestSimilarity = 0;
        int numberOfSameCourses, ageDifference;
        for(User user : users) {
            int sameCourse = countSameCourses(user);
            int ageDiff = Math.abs(age - user.getAge());
            double currentSimilarity = calculateSimilarity(sameCourse, ageDiff);

            if (currentSimilarity > bestSimilarity) {
                bestSimilarity = currentSimilarity;
                bestUser = new User(user);
            }
        }

        return bestUser;
    }

    private int countSameCourses(User user) {
        int count = 0;
        for (String course : this.courses) {
            if (user.getCourses().contains(course)) {
                count++;
            }
        }
        return count;
    }

    private double calculateSimilarity(int sameCourses, int ageDiff) {
        double courseWeight = 0.75;
        double ageWeight = 0.25;

        return (courseWeight * sameCourses) + (ageWeight * ageDiff);
    }

    @Override
    public String toString() {
        return "User: " + name + " " + surname;
    }
}



