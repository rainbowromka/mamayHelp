package http.mamay.help.mamayHelp.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import http.mamay.help.mamayHelp.dataBase.DataImpl;
import http.mamay.help.mamayHelp.dataBase.User;
import http.mamay.help.mamayHelp.dataBase.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(path = "/demo")
public class MyController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DataImpl dataImpl;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String indexing(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("mamayWelcome", "Мамай - это уникальное место, рассположенно в горах недалеко от оз. " +
                "Байкал. Это место посещают каждый год зимой фрирайдеры из россии и зарубежья");
        model.addAttribute("menuItems", dataImpl.getMenuItems());
        return "index";
    }


    @GetMapping(path = "demo/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "demo/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
