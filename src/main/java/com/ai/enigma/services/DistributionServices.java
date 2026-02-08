package com.ai.enigma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributionServices {
    @Autowired
    BotService botService;


    public void distribute(Long chatId, String text) {
        botService.sendToUser(chatId, text);
        }

    public void banUser(Long chatId, Long userIdToBan)
    {
        botService.banUser(chatId,userIdToBan);
    }

    }

