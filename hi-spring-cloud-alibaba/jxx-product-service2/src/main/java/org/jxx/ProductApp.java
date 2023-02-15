package org.jxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 启动
 * @Author: javaear
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("org.jxx.dao")
@EnableDiscoveryClient
public class ProductApp {


    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class,args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
