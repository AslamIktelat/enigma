package com.ai.enigma.repository;

import com.ai.enigma.entities.MessageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepo extends JpaRepository<MessageEntity,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE MessageEntity msg SET msg.reason = :reason, msg.score = :score WHERE msg.MessageId = :message_id")
    public void updateScore_ReasonByMsgId(@Param("message_id") Long chatId, @Param("reason") String reason,@Param("score") int score);

    @Query(" SELECT m FROM MessageEntity m WHERE m.chatId = :chatId ORDER BY m.timestamp DESC LIMIT 10")
    public List<MessageEntity> getMessageEntityBychatId(@Param("chatId")Long chatId,@Param("limit")int numberOfMessages);
}
