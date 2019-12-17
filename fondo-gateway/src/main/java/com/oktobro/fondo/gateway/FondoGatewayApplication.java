package com.oktobro.fondo.gateway;

import com.oktobro.fondo.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2019/12/18
 */
@SpringBootApplication
public class FondoGatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // basic proxy
                .route(r -> r.path("/home")
                        .uri("http://localhost:8081"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(FondoGatewayApplication.class, args);
    }
}
