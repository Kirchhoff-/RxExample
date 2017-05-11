package com.example.kirchhoff.rxexample.utils;

import com.example.kirchhoff.rxexample.data.ApiUser;
import com.example.kirchhoff.rxexample.data.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kirchhoff-
 */

public class UserUtils {

    public static List<User> getUserList() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.firstName = "Mike";
        userOne.lastName = "Jordan";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.firstName = "Steve";
        userTwo.lastName = "Carry";
        userList.add(userTwo);

        User userThree = new User();
        userThree.firstName = "Kobe";
        userThree.lastName = "Bryant";
        userList.add(userThree);

        return userList;
    }

    public static List<ApiUser> getApiUserList() {

        List<ApiUser> apiUserList = new ArrayList<>();

        ApiUser apiUserOne = new ApiUser();
        apiUserOne.firstName = "Mike";
        apiUserOne.lastName = "Jordan";
        apiUserList.add(apiUserOne);

        ApiUser apiUserTwo = new ApiUser();
        apiUserTwo.firstName = "Steve";
        apiUserTwo.lastName = "Carry";
        apiUserList.add(apiUserTwo);

        ApiUser apiUserThree = new ApiUser();
        apiUserThree.firstName = "Kobe";
        apiUserThree.lastName = "Bryant";
        apiUserList.add(apiUserThree);

        return apiUserList;
    }

    public static List<User> convertApiUserListToUserList(List<ApiUser> apiUserList) {

        List<User> userList = new ArrayList<>();

        for (ApiUser apiUser : apiUserList) {
            User user = new User();
            user.firstName = apiUser.firstName;
            user.lastName = apiUser.lastName;
            userList.add(user);
        }

        return userList;
    }
}
