package http.mamay.help.mamayHelp.dataBase.menuItemManager.dao;

import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;

import java.util.List;

public interface MenuItemDao {
    public void addMenuItem(MenuItem menuItem);
    public void updateMenuItem(MenuItem menuItem);
    public void deleteMenuItem(int id);
    public MenuItem getMenuItemById(int id);
    public List<MenuItem> listMenuItems();
}
