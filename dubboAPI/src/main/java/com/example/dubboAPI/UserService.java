package com.example.dubboAPI;

import com.example.domain.User;

public interface UserService {
    User findUser(int id);
    User getUser(String userName);
    User selectUser(String userName,String passWord);
    int addUser(String userName,String passWord);
}
