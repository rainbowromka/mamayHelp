package http.mamay.help.mamayHelp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  Контроллер для контактов
 */
@Controller
@RequestMapping(path = "/vk")
public class VkController {

    @GetMapping(path = "")
    public String vk(@RequestParam(name="name", required=false, defaultValue="Hello VK World!") String name, Model model){
        model.addAttribute("name", name);
        return "vk";
    };


}
