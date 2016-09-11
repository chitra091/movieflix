package io.egen.movieflix;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {
        "io.egen.movieflix.repository",
        "io.egen.movieflix.service",
        "io.egen.movieflix.controller",
        "io.egen.movieflix.entity" })
@EnableWebMvc
public class AppConfig {

}
