package com.in28minutes.database.databasedemo.Repository;

import com.in28minutes.database.databasedemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    @Query("select u from User u where u.email= ?1 and u.password= ?2")
    User findByEmailAndPassword(String email,String Password);

}

