package com.ai.enigma.entities;

import com.ai.enigma.enums.ContentType;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


@Data
@Entity
@Table(name ="messages")
public class MessageEntity {
    @Id
    @Column(name = "message_id")
    private Long MessageId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "time_stamp")
    private Timestamp timestamp;
    @Column(name = "content_type")
    @Enumerated(EnumType.STRING)
    private ContentType contentType;
    @Column(name = "text")
    private String text;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "score")
    private int score;
    @Column(name = "reason")
    private String reason;


}
