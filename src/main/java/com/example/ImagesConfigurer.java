package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagesConfigurer implements WebMvcConfigurer{

    //Añadimos un controlor de recursos
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        //Los dos ** significa que ahora mis recursos están en recursos y en todas las carpetas dentro de esa carpeta.
        registry.addResourceHandler("/recursos/**")
                .addResourceLocations("file:" + "/home/jalendem/recursos/");
    }


    
}
