package com.crud.repo;

import com.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {

    //Updae user by id
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    int updateUserName(@Param("id") int id, @Param("name") String name);

    //Get user by id
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> getByIdCustom(@Param("id") int id);

    //fetch all users
    @Query("SELECT u FROM User u")
    List<User> fetchAllUsers();

    //Delete all the users
    @Modifying
    @Query("DELETE FROM User")
    int deleteAllUsers();

    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    int patchUserName(@Param("id") int id, @Param("name") String name);

}
