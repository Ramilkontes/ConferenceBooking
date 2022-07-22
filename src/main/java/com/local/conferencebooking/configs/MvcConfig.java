package com.local.conferencebooking.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
            {
                    "classpath:/java/resources/", "classpath:/resources/",
                    "classpath:/static/", "classpath:/static/styles.css",
                    "classpath:/static/mobiscroll.jquery.min.css",
                    "classpath:/js/mobiscroll.jquery.min.js", "classpath:/js/calendar.js"
            };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
