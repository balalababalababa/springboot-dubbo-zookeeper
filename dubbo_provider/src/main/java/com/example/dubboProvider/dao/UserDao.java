package com.example.dubboProvider.dao;

import com.example.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
   User findUser(int id);
   User getUser(String userName);
   User selectUser(String userName,String passWord);
   int addUser(String userName,String passWord);
}
