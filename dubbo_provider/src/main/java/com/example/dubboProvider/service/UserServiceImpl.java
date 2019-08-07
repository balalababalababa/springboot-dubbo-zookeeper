package com.example.dubboProvider.service;

import com.example.domain.User;
import com.example.dubboAPI.UserService;
import com.example.dubboProvider.dao.UserDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }
    public User getUser(String userName){
        return userDao.getUser(userName);
    }
    public User selectUser(String userName,String passWord){
        return userDao.selectUser(userName,passWord);
    }
    public int addUser(String userName,String passWord){
        return userDao.addUser(userName,passWord);
    }

}
