package com.jai.aws.controller;


import com.jai.aws.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

    @Autowired
    private SenderService senderService;


    @GetMapping(value = "/send/{msg}")
    public void send(@PathVariable(value = "msg") String msg) {
        senderService.sendMessage(msg);
    }
}
