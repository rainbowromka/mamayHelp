package http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.model;

import javax.persistence.*;
import java.util.Date;

/**
 * пока такое представление класса, содержит информацию о пользователе и информацию о том что он друг
 */
@Entity
@Table(name = "vkUsers")
public class VkUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "url")
    private String url;
    @Column(name = "founded")
    private Date founded;
    @Column(name = "isFriend")
    private Boolean isFriend;

    public VkUser() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getFounded() {
        return founded;
    }
    public void setFounded(Date founded) {
        this.founded = founded;
    }
    public Boolean getFriend() {
        return isFriend;
    }
    public void setFriend(Boolean friend) {
        isFriend = friend;
    }

}
