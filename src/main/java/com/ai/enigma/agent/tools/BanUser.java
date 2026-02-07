package com.ai.enigma.agent.tools;

import com.ai.enigma.services.DistributionServices;
import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Ban_User")
public class BanUser implements MCPTool {
    @Autowired
    DistributionServices distributionServices;

    @Tool(name="Ban_User",description = "Ban user by user id and chat id")
    public void ban(Long chatId,Long userId)
    {
        distributionServices.banUser(String.valueOf(chatId),userId);
    }
}
