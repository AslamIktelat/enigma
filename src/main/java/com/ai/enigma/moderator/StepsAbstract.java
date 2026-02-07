package com.ai.enigma.moderator;

import com.ai.enigma.agent.EnigmaAgentService;
import com.ai.enigma.services.RepoService;
import com.core.ai.CoreAI.tools.ToolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.telegram.telegrambots.meta.api.objects.Message;

public abstract class StepsAbstract {
    @Autowired
    EnigmaAgentService enigmaAgent;
    @Autowired
    RepoService repoService;
    @Autowired
    ToolManager toolManager;
    @Async
    public abstract void excute(Message message);
}
