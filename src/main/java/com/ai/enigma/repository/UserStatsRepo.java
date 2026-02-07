package com.ai.enigma.repository;

import com.ai.enigma.entities.UserStatsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatsRepo extends JpaRepository<UserStatsEntity,String> {

    public UserStatsEntity getByuserchatid (String user_chat_id);
    @Modifying
    @Transactional
    @Query("UPDATE UserStatsEntity user SET user.warningcount = :warningcount WHERE user.userchatid = :userchatid")
    public void updateByuserchatid (@Param("userchatid") String userchatid, @Param("warningcount")int warningcount);

}
