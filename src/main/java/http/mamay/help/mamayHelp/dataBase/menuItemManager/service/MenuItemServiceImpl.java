package http.mamay.help.mamayHelp.dataBase.menuItemManager.service;

import http.mamay.help.mamayHelp.dataBase.menuItemManager.dao.MenuItemDao;
import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemDao menuItemDao;

    public void setMenuItemDao(MenuItemDao menuItemDao) {
        this.menuItemDao = menuItemDao;
    }

    @Override
    @Transactional
    public void addMenuItem(MenuItem menuItem) {
        this.menuItemDao.addMenuItem(menuItem);
    }

    @Override
    @Transactional
    public void updateMenuItem(MenuItem menuItem) {
        this.menuItemDao.updateMenuItem(menuItem);
    }

    @Override
    @Transactional
    public void removeMenuItem(int id) {
        this.menuItemDao.deleteMenuItem(id);
    }

    @Override
    @Transactional
    public MenuItem getMenuItemById(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<MenuItem> listMenuItems() {
        return null;
    }
}
