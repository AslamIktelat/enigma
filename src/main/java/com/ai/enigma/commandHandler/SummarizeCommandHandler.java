package com.ai.enigma.commandHandler;

import org.springframework.scheduling.annotation.Async;

import java.util.List;

public class SummarizeCommandHandler extends HandlerAbstract{
    @Override
    @Async
    public void execute(Long chatId) {
        System.out.println("In SummarizeCommandHandler");
        List<String> messages =this.getMessagesFromChat(chatId,10);
        System.out.println("messages to summ :: "+ messages);
        String summarize = agentService.executeSafety("Summarize the following messages and return only the Summarize as a string and nothing else"+messages).toString();
        System.out.println(" LLM SUM :: "+ summarize);
        this.respond(chatId,summarize);

    }
}
