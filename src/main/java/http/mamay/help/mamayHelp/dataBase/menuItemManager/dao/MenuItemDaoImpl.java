package http.mamay.help.mamayHelp.dataBase.menuItemManager.dao;

import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MenuItemDaoImpl implements MenuItemDao{
    private static final Logger log = LoggerFactory.getLogger(MenuItemDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(menuItem);
        log.info("menu items succersfully saved. Menu Item Details: " + menuItem);
    }

    @Override
    public void updateMenuItem(MenuItem menuItem) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(menuItem);
        log.info("menu items succersfully updated. Menu Item Details: " + menuItem);
    }

    @Override
    public void deleteMenuItem(int id) {
        Session  session = this.sessionFactory.getCurrentSession();

        MenuItem menuItem = (MenuItem) session.load(MenuItem.class, new Integer(id));
        if (menuItem != null) {
            session.delete(menuItem);
        }
        log.info("menu items succersfully deleted. Menu Item Details: " + menuItem);
    }

    @Override
    public MenuItem getMenuItemById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        MenuItem menuItem = (MenuItem) session.load(MenuItem.class, new Integer(id));
        log.info("Menu item succersfully loaded. VkUser Details: " + menuItem);
        return menuItem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MenuItem> listMenuItems() {
        Session session = this.sessionFactory.getCurrentSession();
        List<MenuItem> menuItems = session.createQuery("from menuItems").list();
        for (MenuItem menuItem: menuItems){
            log.info("Menu item list: " + menuItem);
        }
        return menuItems;
    }
}
