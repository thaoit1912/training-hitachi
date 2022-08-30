package com.example.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.microservices.model.User;
import com.example.microservices.model.UserRepo;

@Controller
public class LoginControllerMVC {


    @Autowired
    private UserRepo userRepo;
    @RequestMapping("/")
    public String checkMVC(){
        return "login";
    }
    @RequestMapping("/login")
    public String loginHomePage(@RequestParam("username") String username,
    @RequestParam("password") String password, Model model
    ){
        User u = null;
        try{
            u=userRepo.findByName(username);
        }catch(Exception e){
            System.out.print("User not found");
            return "login";
        }
        if(u!=null){
            model.addAttribute("Username", username);
            return "homepage";

        }
        return "login";
    }
}
