package http.mamay.help.mamayHelp.controllers;

import http.mamay.help.mamayHelp.dataBase.DataImpl;
import http.mamay.help.mamayHelp.dataBase.VideoContentManager.service.VideoContentService;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.BlogRecord;
import http.mamay.help.mamayHelp.dataBase.blogmanager.service.BlogRecordService;
import http.mamay.help.mamayHelp.dataBase.categoryManager.repository.CategoryRepository;
import http.mamay.help.mamayHelp.dataBase.menuItemManager.service.MenuItemRepositary;
import http.mamay.help.mamayHelp.dataBase.sliderItemManager.service.SliderItemRepository;
import http.mamay.help.mamayHelp.dataBase.tweetManager.repository.TweetRepository;
import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import http.mamay.help.mamayHelp.dataBase.userManager.service.UserRepository;
import http.mamay.help.mamayHelp.dataBase.userReviewManager.repository.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(path = "/demo")
public class MamayHelpController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DataImpl dataImpl;
    @Autowired
    private BlogRecordService blogRecordService;
    @Autowired
    private MenuItemRepositary menuItemRepositary;
    @Autowired
    private SliderItemRepository sliderItemRepository;
    @Autowired
    private UserReviewRepository userReviewRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private VideoContentService videoContentService;


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String indexing(@RequestParam(name="page", required=false, defaultValue="0") int page, Model model) {
        model.addAttribute("mamayWelcome", "Мамай - это уникальное место, рассположенно в горах недалеко от оз. " +
                "Байкал. Это место посещают каждый год зимой фрирайдеры из россии и зарубежья");
        model.addAttribute("menuItems", menuItemRepositary.findAll());
        model.addAttribute("curMenu", "Главная");
        model.addAttribute("sliders", sliderItemRepository.findAll());
        model.addAttribute("topBlogs", blogRecordService.findTop5ByOrderByRatingDescNotLazy());
        model.addAttribute("userReviews", userReviewRepository.findAll());
        model.addAttribute("blogs", blogRecordService.findByOrderByPostedDesc(page, 5));
        model.addAttribute("blogPages", blogRecordService.getBlogPages());
        model.addAttribute("curPage", blogRecordService.getCurPage());

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("popularPosts", blogRecordService.findTop5ByOrderByRatingDescNotLazy());
        model.addAttribute("tweets",tweetRepository.findTop5ByOrderByCreatedDesc());
        model.addAttribute("last3tweets", tweetRepository.findTop5ByOrderByCreatedDesc());
        model.addAttribute("about", dataImpl.getAbout());
        model.addAttribute("randomVideo", videoContentService.getRandomVideo());
        return "index";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam(name = "id", required = false, defaultValue = "-1") long id, Model model) {
        model.addAttribute("menuItems", menuItemRepositary.findAll());
        model.addAttribute("curMenu", "");
        model.addAttribute("blog", blogRecordService.findById(id));

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("popularPosts", blogRecordService.findTop5ByOrderByRatingDescNotLazy());
        model.addAttribute("tweets",tweetRepository.findTop5ByOrderByCreatedDesc());
        model.addAttribute("last3tweets", tweetRepository.findTop5ByOrderByCreatedDesc());
        model.addAttribute("about", dataImpl.getAbout());
        model.addAttribute("randomVideo", videoContentService.getRandomVideo());
        model.addAttribute("topBlogs", blogRecordService.findTop5ByOrderByRatingDescNotLazy());
        model.addAttribute("comments", null);
        model.addAttribute("aboutAuthor", null);
        return "blog";
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

//    @GetMapping(path = "/vk")
//    public String vk(@RequestParam(name="name", required=false, defaultValue="Hello VK World!") String name, Model model){
//        model.addAttribute("name", name);
//        return "vk";
//    };
}
