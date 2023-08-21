package com.core.springcoredemo.config;

import com.core.springcoredemo.common.Coach;
import com.core.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
@Bean
    public Coach swimCoach () {
      return new SwimCoach() ;
}
}
