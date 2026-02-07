package com.ai.enigma.mapper;

import com.ai.enigma.entities.ChatEntity;
import com.ai.enigma.entities.MessageEntity;
import com.ai.enigma.entities.UserStatsEntity;
import com.ai.enigma.enums.ContentType;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.sql.Timestamp;

 public class Mapper {


    static public MessageEntity mapTeleMsgToMsgEntity(Message message, ContentType type)
    {
        MessageEntity messageEntity=new MessageEntity();
        messageEntity.setMessageId(Long.valueOf(message.getMessageId()));
        messageEntity.setUserId(message.getFrom().getId());
        messageEntity.setChatId(message.getChat().getId());
        messageEntity.setContentType(type);
        messageEntity.setTimestamp(new Timestamp(message.getDate() * 1000L));
        messageEntity.setText(message.getText());
        return messageEntity;
    }
     static public UserStatsEntity mapTeleMsgToUserStateEntity(Message message)
     {
         String user_chat_id=message.getFrom().getId().toString()+"@"+message.getChatId();
         UserStatsEntity userStats =new UserStatsEntity();
         userStats.setUserchatid(user_chat_id);
         userStats.setUser_id(message.getFrom().getId());
         userStats.setChat_id(message.getChatId());
         userStats.setKarma(1);
         userStats.setWarningcount(0);
         return userStats;
     }
    static public ChatEntity mapTeleChatMemUpdateToEntity(ChatMemberUpdated chatMemberUpdated)
    {
        ChatEntity chatEntity=new ChatEntity();
        chatEntity.setChatId(chatMemberUpdated.getChat().getId());
        chatEntity.setType(chatMemberUpdated.getChat().getType());
        chatEntity.setTitle(chatMemberUpdated.getChat().getTitle());
        chatEntity.setTimestamp(new Timestamp(chatMemberUpdated.getDate()*1000L));
        chatEntity.setAddedBy(chatMemberUpdated.getFrom().getId());
        chatEntity.setRole(chatMemberUpdated.getNewChatMember().getStatus());
        chatEntity.setActive(true);


        return chatEntity;
    }
}
