package cn.wayok.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icelo
 * @date 2021/10/3
 */
@RestController
public class IndexController {

    @GetMapping("/test")
    @Operation(summary = "这个一个测试接口")
    public String index() {
        return "test";
    }
}
