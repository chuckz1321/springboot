package com.western.springboot.controller;

import com.western.springboot.bean.ConfigBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class})
@RequestMapping(value = "/welcome")
public class WelcomeController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return configBean.getGreeting();
    }

    @ApiOperation(value = "user name", notes = "welcome user")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String userWelcome(@PathVariable Integer name){
        return "Hi," + name;
    }
}
