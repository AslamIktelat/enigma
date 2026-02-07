package com.ai.enigma.commandHandler;

import org.springframework.scheduling.annotation.Async;

public class HelpCommandHandler extends HandlerAbstract {

    private final String message="You can use the following commands:\n" +
            "To summarize the lastest messages use /summarize\n" +
            "For help use /help\n";
    @Override
    @Async
    public void execute(Long chatId) {
        this.respond(chatId,message);
    }
}
