package com.pabi.pabiitem;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

import java.net.URI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@SpringBootApplication
@EnableDiscoveryClient
public class PabiItemApplication {

  public static void main(String[] args) {
    SpringApplication.run(PabiItemApplication.class, args);
  }

  @Bean
  RouterFunction<ServerResponse> routerFunction() {
    return route(GET("/docs"), req ->
        ServerResponse.temporaryRedirect(URI.create("swagger-ui/index.html")).build());
  }
}
