package com.codecool.seasonalproductdiscounter.ui.authentication;

import com.codecool.seasonalproductdiscounter.model.users.User;
import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;

import java.util.Scanner;

public class UserAuthenticator {
    private final AuthenticationService authenticationService;

    public UserAuthenticator(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    protected static String getTextInput(String text) {
        String input = "";

        while (input.isEmpty()) {
            System.out.print(text);
            input = new Scanner(System.in).nextLine();
        }

        return input;
    }

    protected User getUser() {
        String userName = getTextInput("Enter username");
        String password = getTextInput("Enter password");
        return new User(userName, password);
    }

    public boolean authenticate() {
        User user = getUser();
        if(authenticationService.authenticate(user)){
            return true;
        }
        return false;
    }
}
