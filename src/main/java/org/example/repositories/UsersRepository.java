package org.example.repositories;

import org.example.models.Users;

public class UsersRepository {
    private static UsersRepository instance;
    private Users user;

    private UsersRepository() {
        user = new Users();
    }

    public static UsersRepository getInstance() {
        if (instance == null) {
            instance = new UsersRepository();
        }
        return instance;
    }

    public void addUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users findByName(String name) {
        return user.getName().equalsIgnoreCase(name) ? user : null;
    }
}
