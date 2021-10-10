package cn.wayok.controller;

import cn.wayok.exception.NotFoundException;
import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author icelo
 * @date 2021/10/3
 */
@Controller
public class IndexController {

    private IShortUrlService shortUrlService;

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
    public void insertOne(@RequestBody UrlDto urlDto) throws InterruptedException {
        shortUrlService.insertOne(urlDto);
    }
}
