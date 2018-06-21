package http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.service;

import http.mamay.help.mamayHelp.dataBase.vk.vkUserManager.model.VkUser;
import org.springframework.data.repository.CrudRepository;

public interface VkUserRepository extends CrudRepository<VkUser, Long> {
}
