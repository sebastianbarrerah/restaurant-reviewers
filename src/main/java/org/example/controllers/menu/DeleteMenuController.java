package org.example.controllers.menu;

import org.example.services.menu.DeleteMenuService;

public class DeleteMenuController {

    private final DeleteMenuService deleteMenuService;

    public DeleteMenuController(DeleteMenuService deleteMenuService) {
        this.deleteMenuService = deleteMenuService;
    }

    public void execute() {
        try {
            deleteMenuService.deleteMenuExecute();
            System.out.println("Menú eliminado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el menú.");
        }
    }

}
