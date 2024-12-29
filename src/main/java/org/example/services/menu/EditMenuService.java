package org.example.services.menu;

import org.example.models.Menu;
import org.example.repositories.MenuRepository;
import org.example.utils.ConsoleHandler;

public class EditMenuService {

    private final MenuRepository repository;
    private final ConsoleHandler consoleHandler;

    public EditMenuService(MenuRepository repository, ConsoleHandler consoleHandler) {
        this.repository = repository;
        this.consoleHandler = consoleHandler;
    }

    public void editMenuExecute() {

        String name = consoleHandler.getString("Ingresa el nombre del menú que deseas editar: ");

        for (Menu menu : repository.showMenus()) {
            if (menu.getName().equals(name)) {
                String newName = consoleHandler.getString("Ingresa el nuevo nombre del menú: ");
                menu.setName(newName);
            }
        }
        System.out.println("No se encontró un menú con ese nombre.");
    }
}
