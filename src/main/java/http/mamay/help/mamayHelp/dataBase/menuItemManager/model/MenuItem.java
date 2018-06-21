package http.mamay.help.mamayHelp.dataBase.menuItemManager.model;

import javax.persistence.*;

@Entity
@Table(name = "menuItems")
public class MenuItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MenuItem() {
    }

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
