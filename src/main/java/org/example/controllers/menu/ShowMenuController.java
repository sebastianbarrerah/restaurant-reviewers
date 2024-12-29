package org.example.controllers.menu;

import org.example.services.menu.ShowMenuService;

public class ShowMenuController {
    private final ShowMenuService showMenuService;

    public ShowMenuController(ShowMenuService showMenuService) {
        this.showMenuService = showMenuService;
    }

    public void execute() {
        try {
            showMenuService.showMenuExecute().forEach(menu -> System.out.println(menu.toString()));
            System.out.println("Todos los menús disponibles:");
        } catch (Exception e) {
            System.out.println("Error al mostrar los menús.");
        }
    }
}
