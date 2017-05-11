package com.example.kirchhoff.rxexample.data;

public class User {
    public long id;
    public String firstName;
    public String lastName;
    public boolean isFollowing;

    public User() {
    }

    public User(ApiUser apiUser) {
        this.id = apiUser.id;
        this.firstName = apiUser.firstName;
        this.lastName = apiUser.lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", isFollowing=" + isFollowing +
                '}';
    }
}
