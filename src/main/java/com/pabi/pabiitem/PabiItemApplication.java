package com.pabi.pabiitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PabiItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PabiItemApplication.class, args);
    }

}
