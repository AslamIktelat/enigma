package com.ai.enigma.config;

import com.ai.enigma.commandHandler.HelpCommandHandler;
import com.ai.enigma.commandHandler.SummarizeCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandsConfig {

    @Bean("help")
    public HelpCommandHandler helpCommandHandler()
    {
        return new HelpCommandHandler();
    }
    @Bean("summarize")
    public SummarizeCommandHandler summarizeCommandHandler()
    {
        return new SummarizeCommandHandler();
    }
}
