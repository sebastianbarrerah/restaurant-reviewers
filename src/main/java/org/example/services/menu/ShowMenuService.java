package org.example.services.menu;

import org.example.models.Menu;
import org.example.repositories.MenuRepository;

import java.util.List;

public class ShowMenuService {
    private final MenuRepository repository;

    public ShowMenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<Menu> showMenuExecute() {
        return repository.showMenus();
    }

}
