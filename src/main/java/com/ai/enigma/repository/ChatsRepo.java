package com.ai.enigma.repository;

import com.ai.enigma.entities.ChatEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChatsRepo extends JpaRepository<ChatEntity,Long> {


    @Modifying
    @Transactional
    @Query("UPDATE ChatEntity chat SET chat.isActive = :isActive WHERE chat.chatId = :chatId")
    public void updateIsActiveByChatId(@Param("chatId") Long chatId, @Param("isActive") Boolean active);
}
