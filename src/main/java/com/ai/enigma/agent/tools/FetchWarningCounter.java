package com.ai.enigma.agent.tools;

import com.ai.enigma.services.RepoService;
import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("FetchWarningCounter")
public class FetchWarningCounter implements MCPTool {

    @Autowired
    RepoService repoService;

    @Tool(name="fetchWarningCounter" ,description = "Fetches the warning counter By the user id and chat id")
    public int fetchWarningCounter(@ToolParam(description = "This is the user id") Long userId, @ToolParam(description = "This is the chat id") Long chatId)
    {
        System.out.println("In fetchWarningCounterById");
        return repoService.getWaringCounterByUserId(userId,chatId);

    }
}
