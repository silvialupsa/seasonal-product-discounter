package com.codecool.seasonalproductdiscounter.ui.selector;

import com.codecool.seasonalproductdiscounter.model.users.User;
import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;
import com.codecool.seasonalproductdiscounter.ui.UiBase;
import com.codecool.seasonalproductdiscounter.ui.factory.UiFactoryBase;

import java.util.List;
import java.util.Scanner;

public class UiSelector {
    private final List<UiFactoryBase> factories;
    private final AuthenticationService authenticationService;

    public UiSelector(List<UiFactoryBase> factories, AuthenticationService authenticationService) {
        this.factories = factories;
        this.authenticationService = authenticationService;
    }

    public UiBase select() {
        System.out.println("Welcome to Seasonal Product Discounter v3");

//        authenticationService.authenticate();
        displayMenu();
        getIntInput();
        //...
        return null;
    }

    private void displayMenu() {
        System.out.println("Available screens:");

        //...
    }

    private static int getIntInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose a number from the screen:");
        int number = myObj.nextInt();
        return number;
    }
}

