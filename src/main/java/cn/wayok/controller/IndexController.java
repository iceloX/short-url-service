package cn.wayok.controller;

import cn.wayok.common.SuccessReturnDto;
import cn.wayok.exception.NotFoundException;
import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.ShortUrlDto;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import com.sun.net.httpserver.Authenticator.Success;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{suffix}")
    @Operation(summary = "这个一个测试接口")
    public SuccessReturnDto index(@PathVariable String suffix) {
        UrlDto one = shortUrlService.getOne(suffix);
        return SuccessReturnDto.builder()
            .data(one)
            .build();
    }

    @PostMapping("url")
    @ResponseBody
    public SuccessReturnDto insertOne(@RequestBody UrlDto urlDto) throws InterruptedException {
        ShortUrlDto shorturl = shortUrlService.insertOne(urlDto);

        return SuccessReturnDto.builder()
            .data(shorturl)
            .build();

    }
}
