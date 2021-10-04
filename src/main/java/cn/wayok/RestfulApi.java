package cn.wayok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author icelo
 * @date 2021/10/3
 */
@EnableOpenApi
@SpringBootApplication
public class RestfulApi {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApi.class);
    }

}
