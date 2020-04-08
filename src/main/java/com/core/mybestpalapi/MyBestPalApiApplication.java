package com.core.mybestpalapi;

import com.core.mybestpalapi.spring.MyBestPalWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MyBestPalWebConfig.class})
public class MyBestPalApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBestPalApiApplication.class, args);
    }
}
