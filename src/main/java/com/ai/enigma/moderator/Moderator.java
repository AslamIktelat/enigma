package com.ai.enigma.moderator;


import com.ai.enigma.agent.ModerateResponse;
import com.ai.enigma.agent.tools.BanUser;
import com.ai.enigma.agent.tools.IncreaseWaringCounter;
import com.ai.enigma.agent.tools.WarnUser;
import org.springframework.scheduling.annotation.Async;
import org.telegram.telegrambots.meta.api.objects.Message;


public class Moderator extends StepsAbstract{

    @Override
    @Async
    public void excute(Message message)
    {
        ModerateResponse moderateResponse = enigmaAgent.moderate(message.getText());

        repoService.updateMsg(message,moderateResponse.getScore(),moderateResponse.getReason());


        int score= moderateResponse.getScore();

        if(61 <= score && score <= 75)
        {
            //Warn the user
            WarnUser tool= (WarnUser) toolManager.getToolByBean("Warn_User");
            tool.excute(message.getChatId(), message.getFrom().getId(),"NOT GOOD 75");

        }
        if (71 <= score && score <= 90)
        {
            // ban for 1 hour
           IncreaseWaringCounter tool= (IncreaseWaringCounter) toolManager.getToolByBean("IncreaseWaringCounter");
           tool.IncreaseWaringCounter(message.getChatId(), message.getFrom().getId());
        }
        if (91 <= score && score <= 100)
        {
            WarnUser tool= (WarnUser) toolManager.getToolByBean("Warn_User");
            tool.excute(message.getChatId(), message.getFrom().getId(),"You will be baned for 5 minutes");
            BanUser banUser= (BanUser) toolManager.getToolByBean("Ban_User");
            banUser.ban(message.getChatId(), message.getFrom().getId());
        }

    }
}
