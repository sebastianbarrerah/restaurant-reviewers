package org.example.controllers.menu;

import org.example.services.menu.EditMenuService;

public class EditMenuController {

    private final EditMenuService editMenuService;

    public EditMenuController(EditMenuService editMenuService) {
        this.editMenuService = editMenuService;
    }

    public void execute() {
        try {
            editMenuService.editMenuExecute();
            System.out.println("Menú editado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al editar el menú.");
        }
    }
}
