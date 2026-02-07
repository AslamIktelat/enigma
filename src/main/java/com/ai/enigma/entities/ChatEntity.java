package com.ai.enigma.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name ="chats")
public class ChatEntity {
    @Id
    @Column(name="chat_id")
    private Long chatId;

    @Column(name="addedby")
    private Long addedBy;


    @Column(name="type")
    private String type;
    @Column(name="title")
    private String title;
    @Column(name="timestamp")
    private Timestamp timestamp;

    @Column(name="role")
    private String role;
    @Column(name="is_active")
    private boolean isActive;



}
