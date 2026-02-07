package com.ai.enigma.config;

import com.ai.enigma.moderator.Moderator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean("Moderator")
    public Moderator moderator()
    {
        return new Moderator();
    }
}
