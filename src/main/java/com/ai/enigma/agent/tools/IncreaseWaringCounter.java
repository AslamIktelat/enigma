package com.ai.enigma.agent.tools;

import com.ai.enigma.services.RepoService;
import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("IncreaseWaringCounter")
public class IncreaseWaringCounter implements MCPTool {

    @Autowired
    RepoService repoService;
    @Tool(name = "increaseWaringCounter",description = "Increase the warning counter for user by user id and chat id")
    public void IncreaseWaringCounter (@ToolParam(description = "This is the user id that sent the message") Long userId,@ToolParam(description = "This is the chat id where the message were sent") Long chatId)
    {
        System.out.println("In updateWaringCounterByUserId");
        repoService.updateWaringCounterByUserId(userId,chatId);
    }
}