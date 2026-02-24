package com.ai.enigma.repository;


import com.ai.enigma.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfoEntity,Long> {
    // create , update for each row , get by id get all
    @Query(" SELECT u FROM UserInfoEntity u WHERE u.user_id = :user_id")
    public UserInfoEntity getUserInfoEntityByUser_id(@Param("user_id")Long user_id);
//    public void UpdateFirst_nameByUser_id(Long userId, String first_name);
//    public void UpdateLast_nameByUser_id(Long userId, String last_name);
//    public void UpdateUsernameByUser_id(Long userId, String username);

}
