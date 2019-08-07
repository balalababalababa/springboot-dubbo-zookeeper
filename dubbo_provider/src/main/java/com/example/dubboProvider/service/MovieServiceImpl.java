package com.example.dubboProvider.service;

import com.example.dubboAPI.MovieService;
import com.example.dubboProvider.dao.MovieDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDao movieDao;
    @Override
    public List getMovie(String date) {
        return movieDao.getMovie(date);
    }
}
