package top.wangdfeng.bookserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wangdfeng.bookserver.entity.SerachKey;
import top.wangdfeng.bookserver.service.SerachService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SearchController {
    @Resource
    private SerachService serachService;

    @RequestMapping("/Serach")
    public List<SerachKey> Serach(String key) throws Exception {
        return serachService.Serach(key);
    }
}
