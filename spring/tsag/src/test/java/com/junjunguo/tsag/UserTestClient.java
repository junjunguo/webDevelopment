package com.junjunguo.tsag;

import com.junjunguo.tsag.testmodel.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080" + "/user/";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers() {
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        try {
            List<LinkedHashMap<String, Object>> usersMap = restTemplate
                    .getForObject(REST_SERVICE_URI + "/list/", List.class);

            if (usersMap != null) {
                for (LinkedHashMap<String, Object> map : usersMap) {
                    System.out.println("User :  Name=" + map.get("name") +
                            ", email=" + map.get("email") +
                            ", password=" + map.get("password") +
                            ", registered time=" + map.get("registeredtime") +
                            ", birth=" + map.get("birth"));
                    ;
                }
            } else {
                System.out.println("No user exist----------");
            }
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }
    }

    /* GET */
    private static void getUserByName() {
        System.out.println("Testing getUserByName by name API----------");
        RestTemplate restTemplate = new RestTemplate();

        try {
            User user = restTemplate.getForObject(REST_SERVICE_URI + "/name/johan", User.class);
            System.out.println("get user by name : " + user);
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }
    }

    /* GET */
    private static void getUserByEmail() {
        System.out.println("Testing getUser By Email API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            User user = restTemplate.getForObject(REST_SERVICE_URI + "/email/ola@a.a", User.class);
            if (user != null) {
                System.out.println("get by email: " + user);
            } else {
                System.out.println("user not found");
            }
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }
    }

    /* POST */
    private static void createUser(User user) {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            URI uri = restTemplate.postForLocation(REST_SERVICE_URI, user, User.class);
            System.out.println("Location : " + uri.toASCIIString());
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }
    }

    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("Sarah", "sarah@a.a", "Norway", "sarah's password",
                getDate("03 14 " + "16:02:37 2011"));
        try {
            restTemplate.put(REST_SERVICE_URI + "sarah@a.a", user);
            System.out.println("update user: " + user);
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }

    }

    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(REST_SERVICE_URI + "sarah@a.a");
            System.out.println("deleted: sarah@a.a");
        } catch (org.springframework.web.client.RestClientException e) {
            e.printStackTrace();
        }


    }

    public static void main(String args[]) {
        createUser(new User("Ola", "ola@a.a", "ola's password"));
        listAllUsers();
        getUserByName();//by name
        getUserByEmail();
        createUser(new User("Sarah", "sarah@a.a", "sarah's password"));
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        createUser(new User("Jonas", "jonas@gmail.co", "jo's password"));
        listAllUsers();
    }


    public static Date getDate(String dateInString) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm dd HH:mm:ss yyyy", Locale.getDefault());

        try {

            Date date = sdf.parse(dateInString);
            System.out.println(date);
            System.out.println(sdf.format(date));
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}