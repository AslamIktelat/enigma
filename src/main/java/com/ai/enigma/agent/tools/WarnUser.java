package com.ai.enigma.agent.tools;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component("Warn_User")
public class WarnUser extends EnigmaMCPTool {


//    @Tool(name = "Warn_User",description = "Warn User by sending him a message")
//    public void excute (Long chatId,Long userId, String warningMessage)
//    {
//        String message="This is a warning message for user ID :: "+userId+"  "+warningMessage;
//        distributionServices.distribute(chatId,message);
//
//    }

    @Override
    public void excute(Message message) {
        distributionServices.distribute(message.getChatId(),"This is a warning message for user ID :: "+message.getFrom().getId()+"  "+"Please follow the group rules to avoid further actions.");
    }
}
