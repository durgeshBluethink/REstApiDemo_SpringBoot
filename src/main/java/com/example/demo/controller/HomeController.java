package com.example.demo.controller;


import com.example.demo.Entity.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HomeController {


    //@Autowired
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/api")
    public List<Users> usersList(){
//        return "Get all information!";
        return userService.getAllUsers();
    }

    @RequestMapping("/api/{id}")
    public  Users getUsersById(@PathVariable String id){
        return userService.getByIdUser(id);
    }

    //@RequestMapping(value = "/api",method = RequestMethod.POST)
    @PostMapping("/api")
    public void addUser(@RequestBody Users user) {
        userService.addUser(user);
    }

   @RequestMapping(value = "/api/{id}",method = RequestMethod.PUT)
    public void updateUsers(@RequestBody Users users, @PathVariable String id){
        userService.updateUsersById(id,users);
    }

    @RequestMapping(value = "api/{id}",method = RequestMethod.DELETE)
    public void deleteById(String id){
         userService.deleteById(id);
    }
}
