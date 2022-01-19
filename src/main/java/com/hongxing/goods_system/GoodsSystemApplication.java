package com.hongxing.goods_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.hongxing.goods_system.mapper")
@EnableCaching
public class GoodsSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsSystemApplication.class, args);
    }

}
