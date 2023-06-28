package com.codecool.seasonalproductdiscounter.service.users;

import com.codecool.seasonalproductdiscounter.model.products.Product;
import com.codecool.seasonalproductdiscounter.model.users.User;

import java.util.List;

public class AuthentificationServiceImpl implements AuthenticationService {
    private final List <User> users;

    public AuthentificationServiceImpl() {
        users = List.of(
                new User("silvialupsa", "1234"),
                new User("user1", "pass1"),
                new User("user2", "pass2"),
                new User("user3", "pass3")
        );
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean authenticate(User user) {
        if(users.contains(user)){
            return true;
        }
        return false;
    }
}
