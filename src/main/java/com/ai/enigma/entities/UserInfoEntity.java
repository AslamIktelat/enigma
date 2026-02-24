package com.ai.enigma.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="users_info")
public class UserInfoEntity {
    @Id
    @Column(name="user_id")
    private long user_id;
    @Column(name="first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "username")
    private String username;
}
