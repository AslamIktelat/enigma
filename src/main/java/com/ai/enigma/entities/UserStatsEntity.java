package com.ai.enigma.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="users_stats")
public class UserStatsEntity {
    @Id
    @Column(name="user_chat_id")
    private String userchatid;
    @Column(name="user_id")
    private long user_id;
    @Column(name="chat_id")
    private  long chat_id;
    @Column(name="warning_count")
    private int warningcount;
    @Column(name = "karma")
    private int karma;
}
