package com.salaryviewer.rest.config;

import com.salaryviewer.rest.resolver.ContextHandlerMethodArgumentResolver;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EntityScan("com.salaryviewer")
@EnableJpaRepositories
@ComponentScan("com.salaryviewer")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ContextHandlerMethodArgumentResolver());
    }
}
