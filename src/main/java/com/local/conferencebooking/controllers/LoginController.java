package com.local.conferencebooking.controllers;

import com.local.conferencebooking.forms.LoginForm;
import com.local.conferencebooking.models.Token;
import com.local.conferencebooking.services.LoginService;
import com.local.conferencebooking.transfer.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping
    public ResponseEntity<TokenDto> login (@RequestBody LoginForm form){
        return ResponseEntity.ok(service.login(form));
    }

}
