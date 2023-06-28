package com.codecool.seasonalproductdiscounter.ui;

import com.codecool.seasonalproductdiscounter.service.users.AuthenticationService;

public abstract class UiBase {
//    private final AuthenticationService authenticationService;
    private final String title;
    private final boolean authenticationNeeded;

    protected UiBase(String title, boolean authenticationNeeded) {
        this.title = title;
//        this.authenticationService = authenticationService;
        this.authenticationNeeded = authenticationNeeded;
    }

//    protected static String getTextInput(String text) {
//        String input = "";
//
//        while (input.isEmpty()) {
//            System.out.print(text);
//            input = new Scanner(System.in).nextLine();
//        }
//
//        return input;
//    }

//    protected User getUser() {
//        String userName = getTextInput("Enter username");
//        String password = getTextInput("Enter password");
//        return new User(userName, password);
//    }

    public void displayTitle() {
        System.out.println(title);
    }

//    public boolean authenticate() {
//        User user = getUser();
//        if(authenticationService.authenticate(user)){
//            return true;
//        }
//        return false;
//    }

    public abstract void run();

    public abstract boolean authenticate();
    public boolean isAuthenticationNeeded(){
        return authenticationNeeded;
    }
}


