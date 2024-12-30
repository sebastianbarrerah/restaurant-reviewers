package org.example.services.User;

import org.example.models.Users;
import org.example.repositories.UsersRepository;
import org.example.utils.ConsoleHandler;

public class AddUserService {
    private UsersRepository usersRepository;
    private final ConsoleHandler consoleHandler;

    public AddUserService(UsersRepository usersRepository, ConsoleHandler consoleHandler) {
        this.usersRepository = usersRepository;
        this.consoleHandler = consoleHandler;
    }

    public void execute() {
        String name = consoleHandler.getString("Ingrese su nombre: ");
        Users user = new Users(name);
        usersRepository.addUser(user);
    }
}
