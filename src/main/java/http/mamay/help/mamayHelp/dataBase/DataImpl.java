package http.mamay.help.mamayHelp.dataBase;

import http.mamay.help.mamayHelp.dataBase.VideoContentManager.model.VideoContent;
import http.mamay.help.mamayHelp.dataBase.VideoContentManager.repository.VideoContentRepository;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.*;
import http.mamay.help.mamayHelp.dataBase.blogmanager.model.content.*;
import http.mamay.help.mamayHelp.dataBase.blogmanager.repository.*;
import http.mamay.help.mamayHelp.dataBase.blogmanager.service.BlogPage;
import http.mamay.help.mamayHelp.dataBase.blogmanager.service.BlogRecordService;
import http.mamay.help.mamayHelp.dataBase.categoryManager.model.Category;
import http.mamay.help.mamayHelp.dataBase.categoryManager.repository.CategoryRepository;
import http.mamay.help.mamayHelp.dataBase.menuItemManager.model.MenuItem;
import http.mamay.help.mamayHelp.dataBase.menuItemManager.service.MenuItemRepositary;
import http.mamay.help.mamayHelp.dataBase.tweetManager.model.Tweet;
import http.mamay.help.mamayHelp.dataBase.tweetManager.repository.TweetRepository;
import http.mamay.help.mamayHelp.dataBase.userManager.model.User;
import http.mamay.help.mamayHelp.dataBase.userManager.service.UserRepository;
import http.mamay.help.mamayHelp.dataBase.userReviewManager.model.UserReview;
import http.mamay.help.mamayHelp.dataBase.userReviewManager.repository.UserReviewRepository;
import http.mamay.help.mamayHelp.dataBase.sliderItemManager.model.SliderItem;
import http.mamay.help.mamayHelp.dataBase.sliderItemManager.service.SliderItemRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataImpl {

    @Autowired
    MenuItemRepositary menuItemRepositary;
    @Autowired
    SliderItemRepository sliderItemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogTagRepository blogTagRepository;
    @Autowired
    BlogRecordService blogRecordService;
    @Autowired
    BlogTumbsRepository blogTumbsRepository;
    @Autowired
    PostImgRepository postImgRepository;
    @Autowired
    BlogUrlRepository blogUrlRepository;
    @Autowired
    BlogTextRepository blogTextRepository;
    @Autowired
    BlogImageRepository blogImageRepository;
    @Autowired
    private UserReviewRepository userReviewRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    VideoContentRepository videoContentRepository;

//    @Getter @Setter
//    List<MenuItem> menuItems = new ArrayList<>();
//    @Getter @Setter
//    List<SliderItem> sliders = new ArrayList<>();
//    List<BlogTag> blogTags = new ArrayList<>();
//    @Getter @Setter
//    List<BlogRecord> top5blogs = new ArrayList<>();
//    @Getter @Setter
//    Iterable<UserReview> userReviews = new ArrayList<>();
//    @Getter @Setter
//    private Page<BlogRecord> blogs;
//    @Getter @Setter
//    int curPage;
//   @Getter @Setter
//    private List<BlogPage> blogPages;
//    @Getter @Setter
//    private Iterable<Category> categories = new ArrayList<>();
//    @Getter @Setter
//    private List<BlogRecord> popularPosts = new ArrayList<>();
//    @Getter @Setter
//    private Iterable<Tweet> tweets = new ArrayList<>();
//    @Getter @Setter
//    private Iterable<Tweet> last3Tweets = new ArrayList<>();
    @Getter @Setter
    private String about;
//    @Getter @Setter
//    private List<VideoContent> videos = new ArrayList<>();

//    public VideoContent getRandomVideo() {
//        videos = videoContentRepository.findAll();
//        int e = (int) (Math.random() * (videos.size() - 1));
//        return videos.get(e);
//    }

    @PostConstruct
    public void iniDataImpl(){

/*
        Создаем в базе данных запись о меню
 */
        menuItemRepositary.deleteAll();
        menuItemRepositary.save(new MenuItem("Главная", "/"));
        menuItemRepositary.save(new MenuItem("Справочник", "guide.html"));
        menuItemRepositary.save(new MenuItem("Карта", "map.html"));
        menuItemRepositary.save(new MenuItem("Галлерея", "picture.html"));
        menuItemRepositary.save(new MenuItem("Контакты", "contact.html"));
/*
        Запись о слайдере
 */
        sliderItemRepository.deleteAll();
        sliderItemRepository.save(new SliderItem("img/gallery/slide2.jpg", "gallery-single.htm"));
        sliderItemRepository.save(new SliderItem("img/gallery/slide1.jpg", "gallery-single.htm"));
//        sliders.clear();
//        for (SliderItem sliderItem: sliderItemRepository.findAll()){
//            sliders.add(sliderItem);
//        }

        userRepository.deleteAll();
        User newUser = new User("Roman", "broken_mouse@mail.ru");
        newUser.setLocation("п. Мамай");
        userRepository.save(newUser);

        User userRoman = null;
        if (userRepository.existsById(newUser.getId())) {
            userRoman  = userRepository.findById(newUser.getId()).get();
        }


        //blogTagRepository.save(new BlogTag(""));
        blogTagRepository.save(new BlogTag("фрирайд"));
        blogTagRepository.save(new BlogTag("мамай"));
        blogTagRepository.save(new BlogTag("карта"));

        BlogRecord blog = new BlogRecord();
//        blog.setIndex(0);
        blog.setTitle("Новые места или хорошо забытые старые =)");
        blog.setPosted(LocalDateTime.of(LocalDate.of(2013, 01, 07), LocalTime.now()));//"07.01.2013");
        blog.setAuthor(userRoman);
        blog.getComments().clear();
        blog.getTags().clear();

        blog.getTags().add(blogTagRepository.findByTag("фрирайд"));
        blog.getTags().add(blogTagRepository.findByTag("мамай"));


        BlogTumbs newTumbs = new BlogTumbs("img/gallery/72923_1357753285_blog_tumbs.jpg");
        blogTumbsRepository.save(newTumbs);
        BlogTumbs tumbs = blogTumbsRepository.findById(newTumbs.getId()).get();
        blog.setTumbs(tumbs);


        newTumbs = new BlogTumbs("img/gallery/72923_1357753285_blog_tumbs2.jpg");
        blogTumbsRepository.save(newTumbs);
        tumbs = blogTumbsRepository.findById(newTumbs.getId()).get();
        blog.setTumbs2(tumbs);

        PostImg newPostImg = new PostImg("img/gallery/72923_1357753285_post_img.jpg");
        postImgRepository.save(newPostImg);
        PostImg postImg = postImgRepository.findById(newPostImg.getId()).get();
        blog.setPostImg(postImg);


        BlogUrl newBlogUrl = new BlogUrl("blog-single.htm");
        blogUrlRepository.save(newBlogUrl);
        BlogUrl blogUrl = blogUrlRepository.findById(newBlogUrl.getId()).get();
        blog.setUrlSingle(blogUrl);
        String blogAnnotation = "Новый Год принято встречать в семье у елки дома, под звук курантов, бокал шампанского! " +
                "Собственно, что и сделали. Но уже второго числа мы выдвинулись в наш снежный Рай.";
        blog.setAnnotation(blogAnnotation);


        BlogText newContent;
        BlogImage newImage;
        int i = 0;

//        blog.getContents().add(new BlogText(blogAnnotation));
        blogTextRepository.save(newContent = new BlogText(blogAnnotation, i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

//        blog.getContents().add(new BlogImage("img/gallery/72923_1357753285.jpg"));
        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753285.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Наконец-то за 8 выездов вначале этого сезона девятый выезд был " +
                "днем. И это чертовски классно — любоваться Байкалом и Хамар-Дабаном в светлое время суток. На первой " +
                "стоянке нынче было около 12 машин. Прогуливались люди, ездили снегоходы.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Уже на заходе в долину в рации разыгрывается драма, кто-то оказывается" +
                " в плену гор, и пытается объехать опасные участки и в эфире то и дело слышно: «Лавина!!!»... Но, слава " +
                "Богу, все живы. И это радует. Разве что немножко неприятно.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Уже в сумерках убираемся в зимухе. Убираем снег с крыши, топим печку, " +
                "ждем захода остальных участников катания. Вечерние посиделки, разговоры и сон!", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Три дня мы зачетно катали на нетронутых склонах. Нашли множество " +
                "новых мест. Первый день катались мы по узкому кулуарчику, находящимся буквально напротив нас. Целью был " +
                "цирк вершины Передовой. Но во время тропежки на крутом участке было ясно, что мы туда не попадем в светлое " +
                "время суток и закатили узкую снежную поляну в лесу.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Второй день мы пошли от зимушки на Кедровую. И удачно выбрали для захода" +
                " левый гребень. Он оказался на порядок короче, комфортнее и живописнее. По пути мы даже разглядывали " +
                "Вершинный цирк и видели людей в цирке. Катались сначала в лесу, потом выкатили прямо к бане через Вершинный" +
                " цирк, можно сказать, в сумерках с фонариком.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753752.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("На фото справа гора Кедровая. Слева Мамайские скалы. Спускались от " +
                "Кедровой два раза. Первый спуск по узкому кулуарчику в центре фотографии. Второй на фото слева вдоль " +
                "границы леса.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Третий день мы пошли уже по натоптанной тропе двумя днями ранее в " +
                "Передовой цирк. Налюбовались с г. Передовая на Байкал, Хамар-Дабан, Северный и Вершинные цирки " +
                "Мамайского ущелья и зачетно спустились.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753739.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("На тропежке. Очень крутой подъем.\n", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753723.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Мамайские скалы.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753708.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Бурятский Нос и Мегаканава.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753692.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("По гребню тропили по перемерзшему снегу. Идти было тяжело.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753678.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Хамар-Дабан на Востоке.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753653.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Снежные поля на обратную сторону ущелья. Можно выбрать день и покатать их =) Сплошное Мясо.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753627.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Юго-Восточные склоны Вершинного цирка. г. Мамай.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/72923_1357753605.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Центральный цирк. Слева Восточный Мамай. Далее по гребню. Западный Мамай, справа Северный Мамай.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());
        blog.setRating(10);
        blogRecordService.save(blog);


//        top5blogs.add(blog);
//        blogs.add(blog);
//        popularPosts.add(blog);
//        last3Blogs.add(blog);

        blog = new BlogRecord();
//        blog.setIndex(1);
        blog.setTitle("Карта Мамая");
//        blog.setPosted("14.12.2017");
        blog.setPosted(LocalDateTime.of(LocalDate.of(2017, 12, 14), LocalTime.now()));
        blog.setAuthor(userRoman);
        blog.getComments().clear();
        blog.getTags().clear();

        blog.getTags().add(blogTagRepository.findByTag("фрирайд"));
        blog.getTags().add(blogTagRepository.findByTag("мамай"));
        blog.getTags().add(blogTagRepository.findByTag("карта"));

//        BlogTumbs newTumbs = new BlogTumbs("img/gallery/72923_1357753285_blog_tumbs.jpg");
//        blogTumbsRepository.save(newTumbs);
//        BlogTumbs tumbs = blogTumbsRepository.findById(newTumbs.getId()).get();
//        blog.setTumbs(tumbs);
//
//
//        newTumbs = new BlogTumbs("img/gallery/72923_1357753285_blog_tumbs2.jpg");
//        blogTumbsRepository.save(newTumbs);
//        tumbs = blogTumbsRepository.findById(newTumbs.getId()).get();
//        blog.setTumbs2(tumbs);
//
//        PostImg newPostImg = new PostImg("img/gallery/72923_1357753285_post_img.jpg");
//        postImgRepository.save(newPostImg);
//        PostImg postImg = postImgRepository.findById(newPostImg.getId()).get();
//        blog.setPostImg(postImg);

        blogTumbsRepository.save(newTumbs = new BlogTumbs("img/gallery/CpTNyF-t2G8_blog_tumbs.jpg"));
        blog.setTumbs(blogTumbsRepository.findById(newTumbs.getId()).get());

        blogTumbsRepository.save(newTumbs = new BlogTumbs("img/gallery/CpTNyF-t2G8_blog_tumbs2.jpg"));
        blog.setTumbs2(blogTumbsRepository.findById(newTumbs.getId()).get());

        postImgRepository.save(newPostImg = new PostImg("img/gallery/CpTNyF-t2G8_post_img.jpg"));
        blog.setPostImg(postImgRepository.findById(newPostImg.getId()).get());

        blogUrlRepository.save(newBlogUrl = new BlogUrl("blog-single.htm"));
        blog.setUrlSingle(blogUrlRepository.findById(newBlogUrl.getId()).get());

        blogAnnotation = "Опубликуем карты Мамая. Огромное спасибо за снимки Степану Зуеву. К сожалению, ERSI обновил " +
                "снимки и сейчас можно увидеть только летние склоны Мамая. За уже годы эти снимки попали в телефоны, были " +
                "напечатаны и заламинированы. Позволяют ориентироваться в ущелье, искать новые линии, планировать походы " +
                "и спуски.";
        blog.setAnnotation(blogAnnotation);

        i = 0;
        blogTextRepository.save(newContent = new BlogText(blogAnnotation, i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Все же, если вы первый раз в горах, то постарайтесь воспользоваться " +
                "знанием бывалых. Или нанять гида или проводника. Карты здесь публикуются только для того, что бы вы могли " +
                "ориентироваться немного в названиях. Если вы уже были катали или у вас хороший опыт по Мамаю, то думаю " +
                "просто не помешают эти «снимочки» в телефоне. Взять их можно в альбоме группы.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Ну и не забывайте. Горы непредсказуемы. Все что я тут могу написать " +
                "про стабильность и безопасность, может оказаться не правдой. Да и вообще люди склонны ошибаться.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Вообще нужно понимать что на Мамае есть аж целых 5 гор с названием Мамай.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());


        blogTextRepository.save(newContent = new BlogText("Мамай Восточный (Мамай), Мамай Западный, Мамай Южный, Мамай Северный " +
                "(Б2), г. Мамай (Истинный Мамай). В скобочках я указал вторые названия гор. Раньше, когда не было зимух," +
                " на Мамае ставили палаточный городок в основном возле Кунга, от него ходили кататься на так называемые " +
                "три березы. Так вот дальше трех берез по гребню находится гора Восточный Мамай. Вот и закрепилось за этой " +
                "горой название просто «Мамай». Впрочем если поискать топографические карты, то выясняется, что официальная " +
                "гора Мамай находится в соседнем цирке (Вершинный цирк). Поэтому ей дали второе название Истинный Мамай.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/CpTNyF-t2G8.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("цирки основных \"Мамаев\"", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/VoHWojMY6X0.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Также стоит отметить что вокруг Мамаев еще есть цирки. Северный, Южный, " +
                "Центральный, Висячий и Вершинный цирк (Бурятский цирк).", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Самое популярное место на Мамае это Три березы. Это не вершина горы, " +
                "просто ключевое место от которого можно начинать свое катание. Еще эту форму рельефа называют лжевершинами. " +
                "На три березы ходят как пешком, так и скитуром. Вообще если у вас нет скитура, то вам дорога на Три березы заказана. " +
                "Ходите пешком. Тропа там почти всегда присутствует. Заход на Три Березы (пеший) по правому (если смотреть снизу вверх) " +
                "гребню. На схеме правее зеленой линии в лесу. Скитуром можно зайти на гору по левому гребню от Кунга(на " +
                "схеме розовая линия) Кстати этот кулуар называют Подъемным. До 2011-2012 гг. на три березы пешком ходили " +
                "по Подъемному кулуару от кунга. Далее идет 1й и 2й учебные кулуары, Мочеточник, Спортивный (Большой) и " +
                "Малый кулуары. Спортивный кулуар частенько укатывают в «хлам» в кулуаре по краям множество дропов. С " +
                "Мочеточником надо быть осторожными. На въезде в кулуар воронка частенько «лавинит».", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/M5Bn5_lQ-bo.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Три Березы. Самое распространенное место катания.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("г. Кедровая. Одно из популярных мест катания. Массовое катание на " +
                "этой горе пожалуй началось с 2013 года. Конечно до этого времени туда ходили и катались. Но заход был от " +
                "г. Мамай Истинная. И мог занимать огромное время, приходилось преодолевать Мамайские скалы. Первые заходы " +
                "мы делали от зимовья ДВКиБ в районе первого моста. Сначала неудачный заход был по правому гребню от оазиса." +
                " Очень далеко оказалось. Потом по левому гребню. Это оказался тогда самый удачный маршрут. С приходом скитура " +
                "стали заходить на гору через цирк, от Первой Морены, через Лягушатник и уходить вправо в лес. Так сократили " +
                "расстояние прилично. Кедровая катается от места, называемое 5 братьев и до скал вдоль гребня. Можно выделить " +
                "несколько кулуаров. Раздельный, 2й и 1й. Впрочем их там больше и названий некоторых я не знаю. На кедровой " +
                "тоже много дропов. Особенно место называемое 5 братьев. Раздельный кулуар немного опасен в катании. Особенно " +
                "в его верхней части. Там уже могут ходить лавины. Впрочем внизу вас ожидают дропы малой и средней величины. " +
                "Еще катают одно место — Оазис. Это редкий лес уходящий в ручьи, можно выделить 2 основных ручья, куда " +
                "сваливаются райдеры и можно еще кататься в лесу и там еще найти 3 ручья коротких но достаточно фановых. Если " +
                "катать оазис до зимовья ДВКиБ то это достаточно протяженное катание на Мамае почти 1.5 км выкат. Оазис " +
                "немного коварен тем, что если катить по левому гребню (если смотреть вниз по склону), то можно укатить в " +
                "Потаеный цирк. Бывали случаи и народ там терялся. Но благополучно находился. Между оазисом и 1м кулуаром " +
                "есть место, называется «Трубочка» прямой и крутой кулуар в лесу, в конце заканчивается дропом и пологим лесом.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/GulakZfiT6o.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("г. Кедровая", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Если смотреть на ущелье от Байкала. То мы с вами поговорили о склонах, " +
                "расположенных справа. Давайте поговорим немного о склонах, расположенных слева. Если опять же прогуляться " +
                "по левым вершинам от Байкала, то мы увидим по порядку следующие горы. Передовая, Сторожевая, Духглавая, " +
                "Мясной (Лесной) пупырь. (у каждой горы есть свои цирки). Передовой цирк, Сторожевой цирк, Двухглавый цирк и " +
                "Мясной цирк. Эти места катают очень редко. Они требуют тщательного подхода к лавинной безопасности. Впрочем " +
                "Передовой и Мясной цирки можно катать по северным и северозападным экспозициям. Передовой цирк труднодоступен " +
                "и его не катают. Долго идти и короткие проезды. Сторожевой цирк уже место достаточно опасное. Двухглавый цирк " +
                "вообще считается самым опасным местом на Мамае. Еще раз повторю. Лучше ходить с опытными ребятами, с гидами " +
                "или проводниками.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Мясной цирк катают весь сезон. Хотя со стороны вершины Двухглавая " +
                "можно ждать сюрпризов и при катании обязательно нужно смотреть в сторону Опасного кулуара. Ну и во второй " +
                "половине зимы эти склоны активно укатываются снегоходчиками. Так что вкусненькое там нужно еще поискать.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/MxFxroe4z-o.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Общая схема вершин по левой стороне р. Б. Мамай (орографически)", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("В 2010 г. в цирке Мясного со стороны г. Дувхглавая сошла огромная лавина, " +
                "в которой погиб снегоходчик. Поэтому сюда нужно ходить с большой осторожностью. Ходят кататься на мясной " +
                "пешком и скитуром. Обычно по правому от «дудки» гребню. Катают в сам цирк, либо в Веселый или дальние кулуары.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/9SWGvOI0uxQ.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Стоить отметить стенку между Двухглавым цирком и Сторожевым. Там есть " +
                "кулуар, называют его Y. И еще Домашние кулуары. Очень крутые кулуары. И во второй половине сезона " +
                "лавиноопасные. В Марте-Апреле месяце по ним ходят мокрые лавины. Все гремит, гудит — то еще зрелище.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogImageRepository.save(newImage = new BlogImage("img/gallery/wyNmFTGJZks.jpg", i++));
        blog.getContents().add(blogImageRepository.findById(newImage.getId()).get());

        blogTextRepository.save(newContent = new BlogText("География катания райдеров постепенно расширяется. Есть еще такие " +
                "места как Мордор и Потаенный цирк. Не отметил я информацию про Мегаканаву, хотя это тоже популярное место " +
                "катания. Катание в цирках Северном и Вершинном, тоже достаточно распространено. В основном это прогулочные " +
                "скитур маршруты или выкаты после спусков с более дальних вершин. Впрочем это в планах.", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blogTextRepository.save(newContent = new BlogText("Берегите себя. Не теряйтесь в горах =)", i++));
        blog.getContents().add(blogTextRepository.findById(newContent.getId()).get());

        blog.setRating(15);
        blogRecordService.save(blog);


//        blogs = blogRecordService.findAll();
//        blogs = blogRecordService.findByOrderByPostedDesc(0, 5);
//        curPage = blogRecordService.getCurPage();
//        blogPages = blogRecordService.getBlogPages();

//        top5blogs = blogRecordService.findTop5ByOrderByRatingDescNotLazy();
//        popularPosts = blogRecordService.findTop5ByOrderByRatingDescNotLazy();




        userReviewRepository.save(new UserReview(userRoman, "Мамай это - мекка прибайкальского фрирайда. Снега тут " +
                "выпадает за сезон до 5 метров. Самая крутая катка ноябрь-декабрь, если Байкал замерзнет позже, еще " +
                "можно покататься отлично в январе. Впрочем кататься тут можно до апреля включительно"));
        userReviewRepository.save(new UserReview(userRoman, "За годы здесь сформировалось маленькое комьюнити, здесь тебе " +
                "рады в каждом домике, на горе охотно покажут куда ехать"));
        userReviewRepository.save(new UserReview(userRoman, "Это место где я отдыхаю от суеты города, здесь я заряжаюсь " +
                "энергией, риск - очищает мой разум, это особенность любого мужчины, здесь я наедине с природой. Ну и " +
                "конечно же риск должен быть оправдан. Мы не лезем на рожон, изучаем горы. Уважаем природу, следим за чистотой."));

//        userReviews =  userReviewRepository.findAll();



        List <Category> categoriesList = new ArrayList<>();
        categoriesList.add(new Category("Справочник", "guide.html"));
        categoriesList.add(new Category("Карта", "map.html"));
        categoriesList.add(new Category("Галлерея", "picture.html"));
        categoriesList.add(new Category("Контакты", "contact.html"));
        categoryRepository.saveAll(categoriesList);
//        categories = categoryRepository.findAll();


        List<Tweet> tweetList = new ArrayList<>();
        tweetList.add(new Tweet(LocalDate.of(2018, 6, 8), "Ну вот уже сайт приобретает черты, скоро открытие"));
        tweetList.add(new Tweet(LocalDate.of(2018,6,7), "Разработан раздел карты"));
        tweetList.add(new Tweet(LocalDate.of(2018, 6, 4), "Теперь вы можете забронировать домик Yeti на сайте"));
        tweetList.add(new Tweet(LocalDate.of(2018,6,1), " Правая колонка завершена"));
        tweetList.add(new Tweet(LocalDate.of(2018,4,30), " Раздел блоги завершен, оформляем остальные разделы"));
        tweetRepository.saveAll(tweetList);
//        tweets = tweetRepository.findTop5ByOrderByCreatedDesc();
//        last3Tweets = tweetRepository.findTop3ByOrderByCreatedDesc();

        about  = "<p>Задача этого сайта сводится к систематизаци и наведения порядка в экстремальном спорте (в частности во " +
                "фрирайде). Цель рассказать о уникальном месте. Заставить вас проникнуться нашим миром. И уже когда вы будете " +
                "нашим гостем не только на сайте, но и в ущелье, вы будете ориентироваться на Мамае. С каждым годом поток " +
                "туристов увеличивается, что плохо сказывается на экологии, мы следим за порядком на Мамае и хотим, что бы " +
                "люди его посещали организованно. Горы представляют собой опасность. Одна из которых - это лавины. Поэтому " +
                "обязательно нужно в горы ходить с гидом или группой опытных катальщиков, за спинами у которы курсы о лавинной " +
                "безопасности и огромный опыт пребывания в зимних горах. Надеюсь вы сознательно подойдете к сказанному и будете " +
                "относиться к себе и природе очень бережно! Ну и не забывайте в горах здороваться с людьми! Может быть этот " +
                "человек вам протянет руку помощи в следующий раз!</p>\n" +
                "\n" +
                "Отличного вам настроения!";

        List<VideoContent> videoContents = new ArrayList<>();
        videoContents.add(new VideoContent("https://www.youtube.com/embed/-TKNdC2JPFo"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/fntJE4tSSvs"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/K-lXNWFbPOk"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/vVf69sqV1mc"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/Jfj6sgvG2WM"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/uTbwzTWk2cc"));
        videoContents.add(new VideoContent("https://www.youtube.com/embed/yWVl58P2rQU"));
        videoContentRepository.saveAll(videoContents);
    }

}
