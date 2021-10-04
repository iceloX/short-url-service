package cn.wayok.controller;

import cn.wayok.exception.NotFoundException;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icelo
 * @date 2021/10/3
 */
@RestController
public class IndexController {

    private IShortUrlService shortUrlService;

    @Autowired
    public void setShortUrlService(IShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping("/test")
    @Operation(summary = "这个一个测试接口")
    public String index() {
        throw new NotFoundException();
    }

    @PostMapping("url")
    public void insertOne(@RequestBody UrlDto urlDto) {
        shortUrlService.insertOne(urlDto);
    }
}
