package http.mamay.help.mamayHelp.dataBase.categoryManager.repository;

import http.mamay.help.mamayHelp.dataBase.categoryManager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
