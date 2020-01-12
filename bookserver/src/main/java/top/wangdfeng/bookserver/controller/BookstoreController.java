package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.Book;
import top.wangdfeng.bookserver.service.BookService;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@RestController
public class BookstoreController {

    /*
    * bookstore_category_fantsy
    *       玄幻接口
    * bookstore_category_city
    *       都市接口
    * bookstore_category_self-cultivation
    *       修真接口
    * bookstore_category_romance
    *        言情接口
    * bookstore_category_girl
    *        女生接口
    * bookstore_category_crossing
    *        穿越接口
    * bookstore_category_online-game
    *        网游接口
    * bookstore_category_sci-fi
    *        科幻接口
    * */

    @Resource
    private BookService bookService;

    @RequestMapping("/bookstore_category_fantsy")
    public List<Book> getFantasyNovel(){
        return bookService.getBookListFantsy();
    }

    @RequestMapping("/bookstore_category_city")
    public List<Book> getCityNovel(){
        return bookService.getBookListCity();
    }


    @RequestMapping("/bookstore_category_self-cultivation")
    public List<Book> getSelfCultivationNovel(){
        return bookService.getBookListSelfCultivation();
    }

    @RequestMapping("/bookstore_category_romance")
    public List<Book> getRomanceNovel(){
        return bookService.getBookListRomance();
    }

    @RequestMapping("/bookstore_category_girl")
    public List<Book> getGirlNovel(){
        return bookService.getBookListGirl();
    }

    @RequestMapping("/bookstore_category_crossing")
    public List<Book> getCrossingNovel(){
        return bookService.getBookListCrossing();
    }

    @RequestMapping("/bookstore_category_online-game")
    public List<Book> getOnlineGameNovel(){
        return bookService.getBookListOnlineGame();
    }

    @RequestMapping("/bookstore_category_sci-fi")
    public List<Book> getSciFiNovel(){
        return bookService.getBookListSciFi();
    }
}
