package org.example.controllers.user;

import org.example.services.User.AddUserService;

public class AddUserController {
    private final AddUserService addUserService;

    public AddUserController(AddUserService addUserService) {
        this.addUserService = addUserService;
    }

    public void execute() {
        addUserService.execute();
        System.out.println("Usuario añadido con éxito.");
    }
}
