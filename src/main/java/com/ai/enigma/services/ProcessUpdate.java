package com.ai.enigma.services;


import com.ai.enigma.commandHandler.HandlerAbstract;
import com.ai.enigma.enums.ContentType;
import com.ai.enigma.moderator.StepsAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.ChatMemberUpdated;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class ProcessUpdate {

    @Autowired
    RepoService repoService;
    @Autowired
    private ApplicationContext context;



    public void processUpdate(Update update,Long botId)
    {
        if(update.hasMyChatMember()) // make sure to enter here only when added to new chat
        {
            // added to new chan / group
            ChatMemberUpdated chatMemberUpdated=update.getMyChatMember();
            handleMemberUpdate(chatMemberUpdated);
        }

        //could be removed or rejoined to group/chanel
        if(update.hasMessage())
        {
            Message message=update.getMessage();
            Long chatId=message.getChatId();

                if( null !=message.getLeftChatMember()) {
                    if (botId.equals(message.getLeftChatMember().getId())) {
                        //go to DB change active to false
                            repoService.activationChat(false,chatId);
                    }
                }
//                if(message.hasDocument())
//                {
//                    //message.getDocument().getFileId(),message.getDocument().getFileName(),chatId);
//                    return;
//                }
//                if(message.hasAudio())
//                {
//                   //message.getAudio().getFileId(),message.getAudio().getFileName(),chatId);
//                    return;
//                }
                if(null != message.getText()) {
                    if(message.getText().startsWith("/"))
                        handleCommands(chatId, message);
                    else
                        handleTextMsg(message);
                }


        }
    }

    private void handleTextMsg(Message message)
    {
        if(message.getChat().getType().equals("supergroup")) // or chanel
        {
            repoService.saveMsg(message, ContentType.TEXT);
            // call the agent to check the msg
            StepsAbstract moderator=context.getBean("Moderator", StepsAbstract.class);
            moderator.excute(message);
        }
    }
    private void handleMemberUpdate(ChatMemberUpdated chatMemberUpdated)
    {
        repoService.createChat(chatMemberUpdated);
    }

    private void handleCommands(Long chatId, Message message) {


        String msg=message.getText();

        String command=msg.split(" ")[0];
       // String args=msg.substring(msg.indexOf(" ")+1);

        command=command.substring(1);
        HandlerAbstract handler;
        try {
            handler = context.getBean(command, HandlerAbstract.class);

        }
        catch (Exception exception)
        {
            handler = context.getBean("help", HandlerAbstract.class);
        }
        handler.execute(chatId);
    }



}
