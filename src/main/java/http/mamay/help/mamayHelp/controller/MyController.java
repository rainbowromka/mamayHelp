package http.mamay.help.mamayHelp.controller;

import http.mamay.help.mamayHelp.dataBase.DataImpl;
import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import http.mamay.help.mamayHelp.dataBase.userManager.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("sliders", dataImpl.getSliders());
        model.addAttribute("topBlogs", dataImpl.getTop5blogs());
        model.addAttribute("userReviews", dataImpl.getUserReviews());
        model.addAttribute("blogs", dataImpl.getBlogs());
        model.addAttribute("last3blogs", dataImpl.getLast3Blogs());
        model.addAttribute("categories", dataImpl.getCategories());
        model.addAttribute("popularPosts", dataImpl.getPopularPosts());
        model.addAttribute("tweets",dataImpl.getTweets());
        model.addAttribute("last3tweets", dataImpl.getLast3Tweets());
        model.addAttribute("about", dataImpl.getAbout());
        model.addAttribute("randomVideo", dataImpl.getRandomVideo());
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

    @GetMapping(path = "/vk")
    public String vk(@RequestParam(name="name", required=false, defaultValue="Hello VK World!") String name, Model model){
        model.addAttribute("name", name);
        return "vk";
    };
}
