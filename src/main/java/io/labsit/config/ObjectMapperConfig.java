package io.labsit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper jacksonBuilder() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.registerModule(new VavrModule());
    }
}
