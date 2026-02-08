package com.ai.enigma.agent.tools;


import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component("IncreaseWaringCounter")
public class IncreaseWaringCounter extends EnigmaMCPTool {


//    @Tool(name = "increaseWaringCounter",description = "Increase the warning counter for user by user id and chat id")
//    public void IncreaseWaringCounter (@ToolParam(description = "This is the user id that sent the message") Long userId,@ToolParam(description = "This is the chat id where the message were sent") Long chatId)
//    {
//        repoService.updateWaringCounterByUserId(userId,chatId);
//    }

    @Override
    public void excute(Message message) {
        repoService.updateWaringCounterByUserId(message.getFrom().getId(), message.getChatId());
    }
}