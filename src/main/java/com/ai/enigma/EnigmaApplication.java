package com.ai.enigma;


import com.ai.enigma.services.BotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@SpringBootApplication
public class EnigmaApplication implements CommandLineRunner {

    @Autowired
    private TelegramBotsApi telegramBotsApi;
    @Autowired
    private BotService botService;

	public static void main(String[] args) {
		SpringApplication.run(EnigmaApplication.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
        telegramBotsApi.registerBot(botService);



    }
}
