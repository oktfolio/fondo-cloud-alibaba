package com.oktobro.fondo.ucenter.security;

import com.alibaba.fastjson.JSON;
import com.oktobro.fondo.common.result.ResultCodeEnum;
import com.oktobro.fondo.common.result.ResultEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2019/12/17
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // OPTIONS request
        http.cors()
                .and()
                .authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // any request are needed to be authenticated
                .anyRequest().authenticated()


                .and()
                .exceptionHandling().authenticationEntryPoint((request, response, authentication) -> {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.getWriter().write(JSON.toJSONString(
                    ResultEntity.unauthorized(ResultCodeEnum.NEED_LOGIN)));
        })

                .and()
                .formLogin()
                .successHandler((request, response, authentication) -> {
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//                    response.getWriter().write(JSON.toJSONString(
//                            ResultEntity.unauthorized(ResultCodeEnum.NEED_LOGIN)));
                })
                .failureHandler((request, response, authentication) -> {
                })

                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {

                })

                .and();
    }
}
