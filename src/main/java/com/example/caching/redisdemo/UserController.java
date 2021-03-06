package com.example.caching.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    RedisTemplate<String,Object> template;

    private static final String USER_KEY_PREFIX = "user::";

    @PostMapping("/user")
    public void setValue(@RequestBody User user){
        template.opsForValue().set(USER_KEY_PREFIX + user.getId(),user);
    }

    @GetMapping("/user")
    public User getValue(@RequestParam("id") int id){
        return (User)template.opsForValue().get(USER_KEY_PREFIX +id);
    }

    @GetMapping("/user/keys")
    public List<User> getUserKeys(){
        Set<String> keys =  template.keys(USER_KEY_PREFIX+"*");
        return keys.stream().map(key -> (User)template.opsForValue().get(key)).collect(Collectors.toList());
    }

}
