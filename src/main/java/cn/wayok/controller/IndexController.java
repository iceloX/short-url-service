package cn.wayok.controller;

import cn.wayok.exception.NotFoundException;
import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author icelo
 * @date 2021/10/3
 */
@Controller
public class IndexController {

    private IShortUrlService shortUrlService;

    @Value(value = "${notfound.url}")
    private String NOT_FOUND_URL ;

    @Autowired
    public void setShortUrlService(IShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/{suffix}")
    @Operation(summary = "这个一个测试接口")
    public String index(@PathVariable String suffix) {
        ShortUrl one = shortUrlService.getOne(suffix);
        return "redirect:" + one.getOrigin();
    }

    @PostMapping("url")
    public String insertOne(@RequestBody UrlDto urlDto) throws InterruptedException {
        String shorturl = shortUrlService.insertOne(urlDto);
        System.out.println(shorturl);
        return "生成的短链地址："+NOT_FOUND_URL+"/"+shorturl;
    }
}
