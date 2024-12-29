package org.example.repositories;

import org.example.models.Menu;

import java.util.LinkedList;
import java.util.List;

public class MenuRepository {
    private static MenuRepository instance;
    private List<Menu> menus;

    private MenuRepository() {
        menus = new LinkedList<>();
    }

    public static MenuRepository getInstance() {
        if (instance == null) {
            instance = new MenuRepository();
        }
        return instance;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> showMenus() {
        return menus;
    }

    public void deleteMenu(String name) {
        this.menus.remove(findByName(name));
    }

    public Menu findByName(String name) {
        return menus.stream()
                .filter(menu -> menu.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void editMenu(String name , String newName ) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                menu.setName(newName);
            }
        }
        System.out.println("No se encontró un menu con ese nombre.");
    }

}
