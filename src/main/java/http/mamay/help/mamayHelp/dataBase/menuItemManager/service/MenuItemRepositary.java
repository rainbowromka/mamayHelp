package http.mamay.help.mamayHelp.dataBase.menuItemManager.service;

import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepositary extends JpaRepository<MenuItem, Long> {
}
