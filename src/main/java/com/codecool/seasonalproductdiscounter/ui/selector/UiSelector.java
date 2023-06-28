package com.codecool.seasonalproductdiscounter.ui.selector;

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

