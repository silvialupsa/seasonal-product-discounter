package com.codecool.seasonalproductdiscounter.ui.selector;

import com.codecool.seasonalproductdiscounter.model.users.User;
import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;
import com.codecool.seasonalproductdiscounter.ui.UiBase;
import com.codecool.seasonalproductdiscounter.ui.factory.UiFactoryBase;

import java.util.List;
import java.util.Scanner;

public class UiSelector {
    private final List<UiFactoryBase> factories;

    public UiSelector(List<UiFactoryBase> factories) {
        this.factories = factories;

    }

    public UiBase select() {
        System.out.println("Welcome to Seasonal Product Discounter v3");

        displayMenu();
        UiFactoryBase theChosenFactory = factories.get(getIntInput()-1);
        System.out.println("You chose " + theChosenFactory.getUiName());
        return theChosenFactory.create();
    }

    private void displayMenu() {
        System.out.println("Available screens:");
        for (int i=0; i < factories.size(); i++){
            System.out.println(String.format("%s. %s", i+1, factories.get(i).getUiName()));
        }
    }

    private static int getIntInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose a number from the screen:");
        int number = myObj.nextInt();
        return number;
    }
}

