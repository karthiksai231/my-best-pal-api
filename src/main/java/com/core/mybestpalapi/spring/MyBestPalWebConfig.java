package com.core.mybestpalapi.spring;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebMvc
public class MyBestPalWebConfig implements WebMvcConfigurer {

    public MyBestPalWebConfig() {
        super();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        final Optional<HttpMessageConverter<?>> converter = converters.stream()
                .filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();

        if(converter.isPresent()) {
            final AbstractJackson2HttpMessageConverter jsonConvertor = (AbstractJackson2HttpMessageConverter) converter.get();
            jsonConvertor.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            //jsonConvertor.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
    }
}
