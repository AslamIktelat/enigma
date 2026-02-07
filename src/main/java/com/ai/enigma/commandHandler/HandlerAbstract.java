package com.ai.enigma.commandHandler;

import com.ai.enigma.enums.ContentType;
import com.ai.enigma.services.DistributionServices;
import com.ai.enigma.services.RepoService;
import com.core.ai.CoreAI.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class HandlerAbstract {

    @Autowired
    AgentService agentService;

    @Autowired
    DistributionServices distributionServices;

    @Autowired
    RepoService repoService;

    public List<String> getMessagesFromChat(Long chatId,int limit)
    {
        List<String> meassgesList=new ArrayList<>();
        repoService.getMessagesFromChat(chatId,limit).forEach(message -> {
            if(message.getContentType().equals(ContentType.TEXT)) {
                String line = "message from :" + message.getUserId().toString() + " message :" + message.getText();
                meassgesList.add(line);
            }
        });
        return meassgesList;
    }
    public void respond(Long chatId,String response)
    {
        distributionServices.distribute(chatId,response);
    }

    public abstract void execute(Long chatId);

}
