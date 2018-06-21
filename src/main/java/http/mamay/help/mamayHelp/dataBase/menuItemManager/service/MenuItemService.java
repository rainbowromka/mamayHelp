package http.mamay.help.mamayHelp.dataBase.menuItemManager.service;

import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    public void addMenuItem(MenuItem menuItem);
    public void updateMenuItem(MenuItem menuItem);
    public void removeMenuItem(int id);
    public MenuItem getMenuItemById(int id);
    public List<MenuItem> listMenuItems();
}
