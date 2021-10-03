package cn.wayok.controller;

import cn.wayok.pojo.ShortUrl;
import cn.wayok.service.ShortUrlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author icelo
 * @date 2021/10/3
 */
@RestController
public class IndexController {
    ShortUrlService service = new ShortUrlService();

    @GetMapping("/test")
    @Operation(summary = "这个一个测试接口")
    public String index() {
        return "test";
    }

    @RequestMapping("/getLongUrl")
    @Operation(summary = "解析端链接并转发到原链接")
    public String getLongUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortUrl = request.getRequestURI();
        String longUrl = service.getLongUrl(shortUrl);
        return "redirect:"+longUrl;
    }

    @GetMapping("/setShortUrl")
    @Operation(summary = "将长链接存入数据库中")
    public void setShortUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShortUrl shortUrl = new ShortUrl();
        String longUrl = request.getRequestURI();
        shortUrl.setLongUrl(longUrl);
        service.setShortUrl(shortUrl);
    }
}
