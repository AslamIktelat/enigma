package com.ai.enigma.services;

import com.ai.enigma.entities.ChatEntity;
import com.ai.enigma.entities.MessageEntity;
import com.ai.enigma.entities.UserStatsEntity;
import com.ai.enigma.enums.ContentType;
import com.ai.enigma.mapper.Mapper;
import com.ai.enigma.repository.ChatsRepo;
import com.ai.enigma.repository.MessagesRepo;
import com.ai.enigma.repository.UserStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Service
public class RepoService {
    @Autowired
    MessagesRepo messagesRepo;
    @Autowired
    UserStatsRepo userStatsRepo;
    @Autowired
    ChatsRepo chatsRepo;


    @Async
    public void saveMsg(Message message, ContentType type)
    {
        MessageEntity messageEntity=Mapper.mapTeleMsgToMsgEntity(message,type);
        messagesRepo.save(messageEntity);
        String user_chat_id=message.getFrom().getId().toString()+"@"+message.getChatId();
        if(null == userStatsRepo.getByuserchatid(user_chat_id))
        {
            UserStatsEntity userStats =Mapper.mapTeleMsgToUserStateEntity(message);
            createUserStats(userStats);
        }
    }
    @Async
    public void updateMsg(Message message,int score,String reason)
    {
        messagesRepo.updateScore_ReasonByMsgId(Long.valueOf(message.getMessageId()),reason,score);
    }

    @Async
    public void createUserStats(UserStatsEntity userStats)
    {
        userStatsRepo.save(userStats);
    }
    @Async
    public void createChat(ChatMemberUpdated chatMemberUpdated)
    {
        ChatEntity chatEntity=Mapper.mapTeleChatMemUpdateToEntity(chatMemberUpdated);
        chatsRepo.save(chatEntity);
    }
    @Async
    public void activationChat(boolean active,Long chatId)
    {
        chatsRepo.updateIsActiveByChatId(chatId,active);
    }
    @Async
    public int getWaringCounterByUserId(Long userId,Long chatId)
    {
        String user_chat_id=userId+"@"+chatId;
       return userStatsRepo.getByuserchatid(user_chat_id).getWarningcount();
    }
    @Async
    public void updateWaringCounterByUserId(Long userId,Long chatId)
    {
        String user_chat_id=userId+"@"+chatId;
        System.out.println("update user :: "+user_chat_id);
       int warningcount= userStatsRepo.getByuserchatid(user_chat_id).getWarningcount();
        System.out.println("update user :: counter before "+warningcount);
        warningcount++;
        userStatsRepo.updateByuserchatid(user_chat_id,warningcount);
    }


    public List<MessageEntity> getMessagesFromChat(Long chatId,int limit)
    {
       return messagesRepo.getMessageEntityBychatId(chatId,limit);
    }
}
