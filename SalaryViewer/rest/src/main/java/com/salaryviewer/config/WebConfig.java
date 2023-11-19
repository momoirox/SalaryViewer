package com.salaryviewer.config;

import com.salaryviewer.resolver.ContextHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@Configuration
public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addArgumentResolvers(
                List<HandlerMethodArgumentResolver> argumentResolvers) {
            argumentResolvers.add(new ContextHandlerMethodArgumentResolver());
        }
}