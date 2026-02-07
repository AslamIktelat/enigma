package com.ai.enigma.agent.tools;

import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component("Warn_Admin")
public class WarnAdmin implements MCPTool {

    @Tool(name = "Warn_Admin",description = "Warn Admin about a message with high Toxicity")
    public void WarnAdmin ()
    {
        System.out.println("In WarnAdmin");

    }
}
