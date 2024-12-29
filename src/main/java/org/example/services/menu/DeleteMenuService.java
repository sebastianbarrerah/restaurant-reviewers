package org.example.services.menu;

import org.example.repositories.MenuRepository;
import org.example.utils.ConsoleHandler;

public class DeleteMenuService {
    private final MenuRepository repository;
    private final ConsoleHandler consoleHandler;

    public DeleteMenuService(MenuRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void deleteMenuExecute() {
        String name = consoleHandler.getString("Ingresa el nombre del menú que deseas eliminar: ");
        repository.deleteMenu(name);
    }
}
