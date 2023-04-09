package com.example.classm8;

import java.util.List;

import static java.util.Arrays.asList;

public class User {
    private String username, name, surname;

    public User(String username, String name, String surname) {
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public User(User user) {
        this.username = user.getUsername();
        this.name = user.getName();
        this.surname = user.getSurname();
    }

    public User() {
        this.username = null;
        this.name = null;
        this.surname = null;
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

    public User matchUser(List<User> users) {
        User bestUser = null;
        double bestSimilarity = 0;
        int numberOfSameCourses;
        for(User user : users) {
            double currentSimilarity = countSameCourses(user);

            if (currentSimilarity > bestSimilarity) {
                bestSimilarity = currentSimilarity;
                bestUser = new User(user);
            }
        }

        return bestUser;
    }
    private int countSameCourses(User user) {
        Communication com = new Communication();
        List<String> myCourses = asList(com.getCourses(getUsername()));
        List<String> userCourses = asList(com.getCourses(user.getUsername()));
        int count = 0;
        for (String course : myCourses) {
            if (userCourses.contains(course)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "User: " + name + " " + surname;
    }
}



