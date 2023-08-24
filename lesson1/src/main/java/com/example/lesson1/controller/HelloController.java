package com.example.lesson1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson1.model.User;

@RestController
@RequestMapping("/api") // api/hello
public class HelloController {
    // @RequestMapping("/hello")
    // @GetMapping(path = "/hello")
    @RequestMapping(path = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/save")
    public String save(){
        return "User saved.";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "User deleted.";
    }
    @GetMapping({"/message/{msg}","/message"})
    public String getMyMessage(@PathVariable(name = "msg",required = false) String message){
        return "Your message is : " + message;
    }
    //path variable = gurkan+yakar
    //requestparam = gurkan+yakar = gurkan yakar

        @GetMapping("/message2")
    public String getMyMessage2(@RequestParam(name = "msg",required = false,defaultValue = "my default value") String message){
        return "Your message is : " + message;
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        System.out.println("User saved!");
        user.setPassword("");
        return user;
    }

    /*
     {
    "name": "Gürkan",
    "surname": "Yakar",
    "username": "gurkanyakar",
    "password": "test"
}
     */

        @PostMapping("/users-all")
    public List<User> saveAllUser(@RequestBody List<User> users){
        System.out.println("All users saved!");
        users.forEach(user -> user.setPassword(""));
        return users;
    }
/*
 [{
    "name": "Gürkan",
    "surname": "Yakar",
    "username": "gurkanyakar",
    "password": "test"
},{
    "name": "Gürkan",
    "surname": "Yakar",
    "username": "gurkanyakar",
    "password": "test"
}]
 */

    @GetMapping("/header")
    public String getHeader(@RequestHeader("My-Header") String myHeader){
        return "Your header is : " + myHeader;
    }
}
