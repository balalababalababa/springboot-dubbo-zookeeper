package com.example.democonsumer.controller;

import com.example.dubboAPI.MovieService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
@RequestMapping("/")
public class MovieController {
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    //但是version一定要指定 不然会找不到服务 直连需要加url="dubbo://localhost:12345"，端口号和配置文件中保持一致
    @Reference(version = "1.0.0")
    private MovieService movieService;
    @RequestMapping("getmovie")
    @ResponseBody
    public List findUser(@RequestParam("date") String date){
        System.out.println(movieService.getMovie(date));
        if(movieService.getMovie(date)!=null){
            return movieService.getMovie(date);
        }else {
            return null;
        }
    }
}
