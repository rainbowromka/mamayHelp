package http.mamay.help.mamayHelp.dataBase.userManager.service;

import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import javafx.beans.value.ObservableObjectValue;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
