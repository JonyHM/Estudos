package br.com.seboDidatico.loja.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

    @RequestMapping(value="/login", 
        method=RequestMethod.GET)
    public String loginForm(){
        return "loginForm";
    }

}