package com.selspring.kelvin.config;

import com.github.javafaker.Faker;
import com.selspring.kelvin.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {
    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
