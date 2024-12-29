package org.example.controllers.menu;

import org.example.services.menu.AddMenuService;

public class AddMenuController {
    private final AddMenuService addMenuService;

    public AddMenuController(AddMenuService addMenuService) {
        this.addMenuService = addMenuService;
    }

    public void execute() {
        try {
            addMenuService.addMenuExecute();
            System.out.println("Menú añadido con éxito.");
        } catch (Exception e) {
            System.out.println("Error al añadir el menú.");
        }
    }
}
