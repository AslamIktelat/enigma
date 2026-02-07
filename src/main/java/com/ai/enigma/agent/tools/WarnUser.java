package com.ai.enigma.agent.tools;

import com.ai.enigma.services.DistributionServices;
import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("Warn_User")
public class WarnUser implements MCPTool {

    @Autowired
    DistributionServices distributionServices;

    @Tool(name = "Warn_User",description = "Warn User by sending him a message")
    public void excute (Long chatId,Long userId, String warningMessage)
    {
        String message="This is a warning message for user ID :: "+userId+"  "+warningMessage;
        distributionServices.distribute(chatId,message);

    }
}
