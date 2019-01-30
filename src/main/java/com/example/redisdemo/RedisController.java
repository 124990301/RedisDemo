package com.example.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/test")
    @ResponseBody
    public String test(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        Object v = redisTemplate.opsForValue().get(key);
        return v.toString();
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(String key,String value){
        redisTemplate.opsForHash().put("guanyu","age","50");
        redisTemplate.opsForHash().put("guanyu","wq","qlyyd");
        String wq = redisTemplate.opsForHash().get("guanyu","wq").toString();
        System.out.println(wq);
        return wq;
    }
}
