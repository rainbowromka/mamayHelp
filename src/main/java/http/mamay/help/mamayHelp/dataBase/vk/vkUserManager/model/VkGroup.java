package http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.model;

import http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.model.VkUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс группы, содержит инмормацию о группе и пользователях в группе
 */
@Entity
@NoArgsConstructor
public class VkGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String Name;
    @Getter @Setter
    private String url;
    @Transient
    @Getter @Setter
    List<VkUser> users = new ArrayList<>();

}
