package com.ai.enigma.Steps;


import com.ai.enigma.agent.ModerateResponse;
import com.ai.enigma.agent.tools.EnigmaMCPTool;
import org.springframework.scheduling.annotation.Async;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;


public class Moderator extends StepsAbstract{

    @Override
    @Async
    public void execute(Message message)
    {
        ModerateResponse moderateResponse = enigmaAgent.moderate(message.getText());

        repoService.updateMsg(message,moderateResponse.getScore(),moderateResponse.getReason());


        int score= moderateResponse.getScore();
        EnigmaMCPTool tool=null;
        List<EnigmaMCPTool> tools= new ArrayList<>();

         /* *  TODO :: LLM should trigger the tools * */
        if(61 <= score && score <= 75)
        {
            //Warn the user
            tools.add ((EnigmaMCPTool) toolManager.getToolByBean("Warn_User"));

        }
        if (71 <= score && score <= 90)
        {
            // ban for 1 hour
            tools.add ((EnigmaMCPTool) toolManager.getToolByBean("IncreaseWaringCounter"));

        }
        if (91 <= score && score <= 100)
        {
            tools.add ((EnigmaMCPTool) toolManager.getToolByBean("Warn_User"));
            tools.add ((EnigmaMCPTool) toolManager.getToolByBean("Ban_User"));

        }
        if(!tools.isEmpty())
        {
            for(EnigmaMCPTool t:tools)
            {
                t.excute(message);
            }
        }

    }
}
