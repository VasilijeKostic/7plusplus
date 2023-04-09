package com.example.classm8;

// ADD LINE   requires java.net.http;   TO module-info.java

import java.net.*;
import java.io.*;
public class Communication {

    public Communication() {}
/*
    public String Request() {
        try {
            // Set the URL of the Node.js server
            URL url = new URL("http://localhost:3000");

            // Open a connection to the server
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method
            con.setRequestMethod("POST");

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response from the server
            // System.out.println(response.toString());
            return response.toString();

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "ERROR_ERROR_ERROR";
        }
    }

    public String Request(String suffix) {
        try {
            // Set the URL of the Node.js server
            URL url = new URL("http://localhost:3000/" + suffix);

            // Open a connection to the server
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method
            con.setRequestMethod("POST");

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response from the server
            // System.out.println(response.toString());
            return response.toString();
            // JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "ERROR_ERROR_ERROR";
        }
    }
*/
    public String Request(String suffix, String argument) {
        try {
            // Set the URL of the Node.js server
            URL url = new URL("http://localhost:3000/" + suffix);

            // Open a connection to the server
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method
            con.setRequestMethod("POST");

            // SEND START
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "text/plain");

            OutputStream os = con.getOutputStream();
            os.write(argument.getBytes());
            os.flush();
            os.close();
            // SEND END

            // Read the response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response from the server
            // System.out.println(response.toString());
            return response.toString();
            // JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "ERROR_ERROR_ERROR";
        }
    }

    public void RequestNothing(String suffix, String argument) {
        try {
            // Set the URL of the Node.js server
            URL url = new URL("http://localhost:3000/" + suffix);

            // Open a connection to the server
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method
            con.setRequestMethod("POST");

            // SEND START
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "text/plain");

            OutputStream os = con.getOutputStream();
            os.write(argument.getBytes());
            os.flush();
            os.close();
            // SEND END
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public String[] getUser(String username){
        String username_name_surname = this.Request("getUser", username);
        return username_name_surname.split("[$]");
    }

    public String[] getCourses(String username){
        String courses = this.Request("getCourses", username);
        return courses.split("[$]");
    }

    public String[] getLectures(String course){
        String lectures = this.Request("getLectures", course);
        return lectures.split("[$]");
    }

    public String[] getOnlineUsers(String lecture){
        String onlineUsers = this.Request("getOnlineUsers", lecture);
        return onlineUsers.split("[$]");
    }

    public void insertUser(String username, String name, String surname){
        this.RequestNothing("insertUser", username + "$" + name + "$" + surname);
    }

    public void insertUsernameLecture(String username, String lecture){
        this.RequestNothing("insertUsernameLecture", username + "$" + lecture);
    }

    public void removeUsernameLecture(String username, String lecture){
        this.RequestNothing("removeUsernameLecture", username + "$" + lecture);
    }
}