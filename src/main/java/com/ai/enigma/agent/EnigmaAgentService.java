package com.ai.enigma.agent;


import com.core.ai.CoreAI.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service("EnigmaAgentService")
public class EnigmaAgentService {
    @Autowired
    AgentService agentService;

    public ModerateResponse moderate(String msg)
    {
       return (ModerateResponse) agentService.executeSafety("check the message for Toxicity with level Strict message="+msg,ModerateResponse.class);
    }

//    public ActionResponse action(int score,Message message)
//    {
//          Will use this func to let the llm decide on which tool to call
    //      based on table of rules and scores range
//    }

    public String readPromptFromFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readString(path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load prompt from file: " + filePath, e);
        }
    }

}
