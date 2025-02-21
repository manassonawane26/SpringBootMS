package com.manas.springcoredemo.config;

import com.manas.springcoredemo.common.Coach;
import com.manas.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // @Bean
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
