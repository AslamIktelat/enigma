package com.ai.enigma.services;

import com.ai.enigma.config.BotProperties;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.methods.groupadministration.BanChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class BotService extends TelegramLongPollingBot {
    @Autowired
    BotProperties botProperties;
    @Autowired
    ProcessUpdate processUpdate;

    private Long botId=null;

    @Override
    public String getBotUsername() {
        return botProperties.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botProperties.getBotToken();
    }

    @PostConstruct
    private void init()
    {
        User botUser = null;
        try {
            botUser = execute(new GetMe());
            botId= botUser.getId();
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update);

        processUpdate.processUpdate(update,botId);


    }



    public void sendToUser(SendMessage message) {

        try {
            if(message!=null) {
                this.executeAsync(message);
            }
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendToUser(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        this.sendToUser(message);
    }

    public void banUser(Long chatId, Long userIdToBan) {
        BanChatMember banChatMember = new BanChatMember();
        banChatMember.setChatId(String.valueOf(chatId));
        banChatMember.setUserId(userIdToBan);
        // Optional: specify a untilDate (Unix timestamp) for a temporary ban.
        // If not set, the ban is permanent.
         banChatMember.setUntilDate((int) (System.currentTimeMillis() / 1000L + 300)); // Ban for 5 minutes

        try {
            execute(banChatMember);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            // Handle error, e.g. insufficient admin rights
        }
    }
}
