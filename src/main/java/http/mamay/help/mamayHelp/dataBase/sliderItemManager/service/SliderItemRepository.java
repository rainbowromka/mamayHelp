package http.mamay.help.mamayHelp.dataBase.sliderItemManager.service;

import http.mamay.help.mamayHelp.dataBase.sliderItemManager.model.SliderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SliderItemRepository extends JpaRepository<SliderItem, Long> {
}
