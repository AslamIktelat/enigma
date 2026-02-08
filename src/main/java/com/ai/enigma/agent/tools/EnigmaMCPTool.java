package com.ai.enigma.agent.tools;

import com.ai.enigma.services.DistributionServices;
import com.ai.enigma.services.RepoService;
import com.core.ai.CoreAI.tools.MCPTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Message;


public abstract class EnigmaMCPTool  implements MCPTool {

    @Autowired
    DistributionServices distributionServices;

    @Autowired
    RepoService repoService;

    public abstract void excute (Message message);


}
