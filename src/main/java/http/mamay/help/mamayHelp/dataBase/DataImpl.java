package http.mamay.help.mamayHelp.dataBase;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataImpl {

    List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @PostConstruct
    public void iniDataImpl(){
        menuItems.add(new MenuItem("Главная", "index.html"));
        menuItems.add(new MenuItem("Справочник", "guide.html"));
        menuItems.add(new MenuItem("Карта", "map.html"));
        menuItems.add(new MenuItem("Галлерея", "picture.html"));
        menuItems.add(new MenuItem("Контакты", "contact.html"));
    }
}
