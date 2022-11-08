package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleController {

    Logger logger = LoggerFactory.getLogger(ExampleController.class);

    @GetMapping("/listings")
    public List<String> articlesDummy(){
        //Values fetched from session.
        String ip = "10.0.0.10";
        String username = "xX_Adam_Xx"; //Anonymous if not signed in.
        String endpoint = "/listings";

        List<String> xs = new ArrayList<>();
        xs.add("Book");
        xs.add("Tablet");

        //Log access info
        String msg = "ACCESS" + " " + username + " " + ip + " " + endpoint;
        logger.info(msg);

        return xs;
    }

    @GetMapping("/addBid")
    public boolean bid(@RequestParam("id") String id, @RequestParam("amount") String amount){
        //Values fetched from session.
        String ip = "10.0.0.10";
        String username = "xX_Adam_Xx"; //Anonymous if not signed in.
        String endpoint = "/bid";

        //Log access info
        String msg = "BID " + username + " " + ip + " " + id + " " + amount;
        logger.info(msg);

        return true;
    }

    @GetMapping("/login")
    public String login(){
        //Values fetched from session.
        String ip = "10.0.0.10";
        String username = "anonymous"; //Anonymous if not signed in.
        String endpoint = "/login";

        //Log access info
        String msg = "ACCESS " + username + " " + ip + " " + endpoint;
        logger.info(msg);

        return "<form method='POST'>" +
                "<input name='username' type='string' />" +
                "<button type='submit'>Submit</button>" +
                "</form>";
    }

    @PostMapping("/login")
    public String loginPost(){
        //Values fetched from session.
        String ip = "10.0.0.10";
        String username = "anonymous"; //Anonymous if not signed in.
        String endpoint = "/login";
        String type = "FAILED_SECURITY_LOGIN";

        //Log security info
        String msg = "SECURITY" + " " + ip + " " + username + " " + type ;
        logger.warn(msg);

        return "FAILED TO LOGIN <a href='/login'>Try again</a>";
    }
}
