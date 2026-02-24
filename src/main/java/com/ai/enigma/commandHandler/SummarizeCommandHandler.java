package com.ai.enigma.commandHandler;

import org.springframework.scheduling.annotation.Async;

import java.util.List;

public class SummarizeCommandHandler extends HandlerAbstract{
    @Override
    @Async
    public void execute(Long chatId) {
        List<String> messages =this.getMessagesFromChat(chatId,10);
        String summarize = agentService.executeSafety("Summarize the following messages and return only the Summarize as a string and nothing else"+messages).toString();
        this.respond(chatId,summarize);

    }
}
