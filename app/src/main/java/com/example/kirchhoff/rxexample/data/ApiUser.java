package com.example.kirchhoff.rxexample.data;

public class ApiUser {
    public long id;
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        return "ApiUser{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                '}';
    }
}